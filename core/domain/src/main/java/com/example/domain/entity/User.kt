package com.example.domain.entity

data class User(
    val name: String,
    val email: String,
    val phone: String,
    val chats: List<Chats>
)