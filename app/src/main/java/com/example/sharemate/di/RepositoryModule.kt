package com.example.sharemate.di

import com.example.data.repositoryimpl.AuthRepositoryImpl
import com.example.data.repositoryimpl.ChatRepositoryImpl
import com.example.data.repositoryimpl.UserRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.ChatRepository
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindAuthRepository(authRepository: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindChatRepository(chatRepository: ChatRepositoryImpl): ChatRepository

    @Binds
    fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}