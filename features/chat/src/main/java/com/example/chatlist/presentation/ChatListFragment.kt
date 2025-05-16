package com.example.chatlist.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chat.databinding.FragmentChatListBinding
import com.example.chatlist.store.state.ChatsListState
import com.example.chatlist.viewcontroller.ChatsListViewController
import com.example.domain.controllers.ToolBarController
import dagger.hilt.android.AndroidEntryPoint
import ru.fabit.viewcontroller.core.StateView
import ru.fabit.viewcontroller.coroutines.registerViewController
import ru.fabit.viewcontroller.coroutines.viewControllers

@AndroidEntryPoint
class ChatListFragment : Fragment(), StateView<ChatsListState> {

    private lateinit var binding: FragmentChatListBinding
    private val viewController: ChatsListViewController by viewControllers()
    private lateinit var adapter: ChatListAdapter
    private var toolBarController: ToolBarController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewController(viewController)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewController.back()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ToolBarController) {
            toolBarController = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarController?.show(true)
        initAdapter()
        initFunc()
    }

    private fun initAdapter() {
        adapter = ChatListAdapter(viewController)
        binding.rvChats.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ChatListFragment.adapter
        }
    }

    private fun initFunc() {

    }


    companion object {
        const val TAG = "Chat"
        fun newInstance(): ChatListFragment = ChatListFragment()
    }

    override fun renderState(state: ChatsListState, payload: Any?) {
        adapter.setData(state.chatsList)
    }
}