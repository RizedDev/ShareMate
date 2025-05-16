package com.example.chatlist.store.state

import com.example.domain.entity.Chats
import com.example.domain.entity.User

data class ChatsListState(
    val user: User? = null,
    val chatsList: List<Chats> = listOf()
)