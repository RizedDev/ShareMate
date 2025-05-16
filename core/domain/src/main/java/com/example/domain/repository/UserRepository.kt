package com.example.domain.repository

import com.example.domain.entity.Chats
import com.example.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getFromApi()
    suspend fun getDatabase(): Flow<User?>
    suspend fun updateUser(user: User)
    suspend fun updateChats(chats: Chats)
}
