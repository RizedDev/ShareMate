package com.example.chatlist.store.action

import com.example.domain.entity.Chats
import com.example.domain.entity.User

sealed interface ChatsListAction {
    data object Init : ChatsListAction
    data object Back : ChatsListAction

    data class GetUserData(val user: User, val chatsList: List<Chats>) : ChatsListAction
    data class OpenChatScreen(val chatId: String): ChatsListAction
    data class Error(val t: Throwable): ChatsListAction
}