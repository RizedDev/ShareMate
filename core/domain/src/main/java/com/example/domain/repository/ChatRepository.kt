package com.example.domain.repository

import com.example.domain.entity.Message
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun getFromApi(chatId: String)
    suspend fun getDataBase(): Flow<Message?>
    suspend fun updateMessage(message: Message)
    suspend fun sendMessage(text: String, chatId: String)
}