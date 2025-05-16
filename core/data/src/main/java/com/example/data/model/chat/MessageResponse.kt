package com.example.data.model.chat

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    val text: String = "",
    val senderId: String = "",
    val timestamp: String = ""
)