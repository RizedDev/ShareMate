package com.example.chatlist.store.reducer

import com.example.chatlist.store.Reducer
import com.example.chatlist.store.action.ChatsListAction
import com.example.chatlist.store.state.ChatsListState

object ChatsListReducer: Reducer {
    override fun ChatsListState.reduce(action: ChatsListAction): ChatsListState {
        return when (action) {
            is ChatsListAction.GetUserData -> copy(
                user = action.user,
                chatsList = action.chatsList
            )

            else -> copy()
        }
    }
}