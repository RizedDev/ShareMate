package com.example.sharemate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fabit.udf.store.coroutines.ErrorHandler
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideErrorHandler(): ErrorHandler = object : ErrorHandler {
        override fun handle(t: Throwable) {
            println(t.stackTrace)
        }
    }
}