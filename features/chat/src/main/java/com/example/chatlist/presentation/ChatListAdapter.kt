package com.example.chatlist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.databinding.ItemChatBinding
import com.example.domain.entity.Chats

interface OnItemClickListener {
    fun onItemClick(chatId: String)
}

class ChatListAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ChatsListViewHolder>() {
    private val chats = mutableListOf<Chats>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsListViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatsListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ChatsListViewHolder, position: Int) {
        val objectItems = chats[position]
        holder.tvUserName.text = objectItems.interlocutor
        holder.tvLastMessage.text = objectItems.messageList.last().text
        holder.tvTime.text = objectItems.messageList.last().timestamp

        holder.item.setOnClickListener {
            onItemClickListener.onItemClick(objectItems.id)
        }
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    fun setData(data: List<Chats>) {
        val diffCallback = ChatsCallBack(chats, data)
        val diffItems = DiffUtil.calculateDiff(diffCallback)
        chats.clear()
        chats.addAll(data)
        notifyDataSetChanged()
        diffItems.dispatchUpdatesTo(this)
    }

}

class ChatsCallBack(
    private val oldList: List<Chats>,
    private val newList: List<Chats>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}


class ChatsListViewHolder(binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root) {
    val item = binding.item
    val tvUserName = binding.tvUserName
    val tvTime = binding.tvTime
    val tvLastMessage = binding.tvLastMessage
}

