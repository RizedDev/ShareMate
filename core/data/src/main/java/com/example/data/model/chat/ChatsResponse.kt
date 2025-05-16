package com.example.data.model.chat

import kotlinx.serialization.Serializable

@Serializable
data class ChatsResponse(
    val id: String = "",
    val interlocutor: String = "",
    val messageList: List<MessageResponse> = listOf()
)