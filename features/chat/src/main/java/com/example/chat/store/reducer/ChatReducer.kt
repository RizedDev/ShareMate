package com.example.chat.store.reducer


import com.example.chat.store.action.ChatAction
import com.example.chat.store.state.ChatState
import ru.fabit.udf.store.coroutines.Reducer

object ChatReducer: Reducer<ChatState, ChatAction> {
    override fun ChatState.reduce(action: ChatAction): ChatState {
        return when(action) {
            else -> copy()
        }
    }
}