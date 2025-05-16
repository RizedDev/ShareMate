package com.example.domain.entity

data class Chats(
    val id: String,
    val interlocutor: String,
    val messageList: List<Message>
)