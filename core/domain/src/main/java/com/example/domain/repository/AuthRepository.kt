package com.example.domain.repository

interface AuthRepository {
    suspend fun entry(email: String, password: String)
    suspend fun register(email: String, password: String, name: String)
    suspend fun exit()
}