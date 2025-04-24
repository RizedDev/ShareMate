package com.example.auth.di

import com.example.auth.store.EntryStore
import com.example.auth.store.action.EntryAction
import com.example.auth.store.actionhandler.OpenChatScreenActionHandler
import com.example.auth.store.actionhandler.OpenRegisterScreenActionHandler
import com.example.auth.store.reducer.AuthReducer
import com.example.auth.store.sideeffect.EntrySideEffect
import com.example.auth.store.state.EntryState
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
object AuthStoreModule {
    @Provides
    @ViewModelScoped
    fun provideAuthStore(
        errorHandler: ErrorHandler,
        openRegisterScreenActionHandler: OpenRegisterScreenActionHandler,
        openChatScreenActionHandler: OpenChatScreenActionHandler,
        entrySideEffect: EntrySideEffect
    ): EntryStore {
        return EntryStore(
            StoreKit(
                startState = EntryState(),
                bootstrapAction = EntryAction.Init,
                reducer = AuthReducer,
                errorHandler = errorHandler,
                actors = Actors(
                    sideEffects = listOf(entrySideEffect),
                    actionHandlers = listOf(openRegisterScreenActionHandler, openChatScreenActionHandler)
                )
            )
        )
    }
}