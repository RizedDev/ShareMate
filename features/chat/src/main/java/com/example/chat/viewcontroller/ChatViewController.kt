package com.example.chat.viewcontroller

import com.example.chat.store.ChatStore
import com.example.chat.store.action.ChatAction
import com.example.chat.store.state.ChatState
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.fabit.viewcontroller.coroutines.ViewController
import javax.inject.Inject

@HiltViewModel
class ChatViewController @Inject constructor(
    store: ChatStore
) : ViewController<ChatState, ChatAction>(store){

    fun back() {
        dispatchAction(ChatAction.Back)
    }
}