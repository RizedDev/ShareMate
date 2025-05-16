package com.example.chat.di

import com.example.chat.store.ChatStore
import com.example.chat.store.action.ChatAction
import com.example.chat.store.reducer.ChatReducer
import com.example.chat.store.state.ChatState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.fabit.udf.store.coroutines.Actors
import ru.fabit.udf.store.coroutines.ErrorHandler
import ru.fabit.udf.store.coroutines.StoreKit

@Module
@InstallIn(ViewModelComponent::class)
object ChatStoreModule {
    @Provides
    @ViewModelScoped
    fun provideChatStore(
        errorHandler: ErrorHandler
    ): ChatStore = ChatStore(
        StoreKit(
            startState = ChatState(),
            bootstrapAction = ChatAction.Init,
            reducer = ChatReducer,
            errorHandler = errorHandler,
            actors = Actors(
                bindActionSources = listOf(),
                actionSources = listOf(),
                actionHandlers = listOf(),
                sideEffects = listOf()
            )
        )
    )
}