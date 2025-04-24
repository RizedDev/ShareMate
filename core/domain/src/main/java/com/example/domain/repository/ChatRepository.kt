package com.example.domain.repository

import com.example.domain.entity.Message
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun sendMessage(message: Message)
}