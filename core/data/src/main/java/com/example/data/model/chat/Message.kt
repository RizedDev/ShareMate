package com.example.data.model.chat

data class Message(
    val text: String = "",
    val sender: String = "Anonymous",
    val timestamp: Long = System.currentTimeMillis()
)