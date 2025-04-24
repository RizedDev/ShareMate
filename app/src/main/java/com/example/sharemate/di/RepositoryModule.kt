package com.example.sharemate.di

import androidx.transition.Visibility.Mode
import com.example.data.repositoryimpl.AuthRepositoryImpl
import com.example.data.repositoryimpl.ChatRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.ChatRepository
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
}