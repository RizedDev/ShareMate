package com.example.data.model.user

import com.example.data.model.chat.ChatsResponse
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val chats: List<ChatsResponse> = listOf()
)
