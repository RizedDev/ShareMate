package com.example.auth.di

import com.example.auth.store.AuthStore
import com.example.auth.store.action.AuthAction
import com.example.auth.store.actionhandler.OpenRegisterScreenActionHandler
import com.example.auth.store.reducer.AuthReducer
import com.example.auth.store.state.AuthState
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
        openRegisterScreenActionHandler: OpenRegisterScreenActionHandler
    ): AuthStore {
        return AuthStore(
            StoreKit(
                startState = AuthState(),
                bootstrapAction = AuthAction.Init,
                reducer = AuthReducer,
                errorHandler = errorHandler,
                actors = Actors(
                    actionHandlers = listOf(openRegisterScreenActionHandler)
                )
            )
        )
    }
}