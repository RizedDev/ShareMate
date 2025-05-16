package com.example.chatlist.di

import com.example.chatlist.store.ChatsListStore
import com.example.chatlist.store.action.ChatsListAction
import com.example.chatlist.store.actionhandler.GetUserFromApiActionHandler
import com.example.chatlist.store.actionhandler.OpenChatScreenActionHandler
import com.example.chatlist.store.actionsource.GetUserFromDataBaseActionSource
import com.example.chatlist.store.reducer.ChatsListReducer
import com.example.chatlist.store.state.ChatsListState
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
object ChatsListStoreModule {
    @Provides
    @ViewModelScoped
    fun provideChatsStore(
        errorHandler: ErrorHandler,
        getUserFromApiActionHandler: GetUserFromApiActionHandler,
        getUserFromDataBaseActionSource: GetUserFromDataBaseActionSource,
        openChatScreenActionHandler: OpenChatScreenActionHandler
    ): ChatsListStore = ChatsListStore(
        StoreKit(
            startState = ChatsListState(),
            bootstrapAction = ChatsListAction.Init,
            reducer = ChatsListReducer,
            errorHandler = errorHandler,
            actors = Actors(
                bindActionSources = listOf(),
                actionSources = listOf(getUserFromDataBaseActionSource),
                actionHandlers = listOf(getUserFromApiActionHandler, openChatScreenActionHandler),
                sideEffects = listOf()
            )
        )
    )
}