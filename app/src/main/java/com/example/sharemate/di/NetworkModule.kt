package com.example.sharemate.di

import com.example.data.service.UserService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideUserService(
        database: FirebaseDatabase,
        firebaseAuth: FirebaseAuth
    ): UserService = UserService(database, firebaseAuth)
}