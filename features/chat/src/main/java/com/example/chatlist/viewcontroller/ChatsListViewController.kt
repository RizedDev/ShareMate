package com.example.chatlist.viewcontroller

import com.example.chatlist.presentation.OnItemClickListener
import com.example.chatlist.store.ChatsListStore
import com.example.chatlist.store.action.ChatsListAction
import com.example.chatlist.store.state.ChatsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.fabit.viewcontroller.coroutines.ViewController
import javax.inject.Inject

@HiltViewModel
class ChatsListViewController @Inject constructor(
    store: ChatsListStore
) : ViewController<ChatsListState, ChatsListAction>(store), OnItemClickListener {

    fun back() {
        dispatchAction(ChatsListAction.Back)
    }

    override fun onItemClick(chatId: String) {
        dispatchAction(ChatsListAction.OpenChatScreen(chatId))
    }
}