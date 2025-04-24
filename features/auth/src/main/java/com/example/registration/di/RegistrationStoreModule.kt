package com.example.registration.di

import com.example.registration.store.RegistrationStore
import com.example.registration.store.action.RegistrationAction
import com.example.registration.store.actionhandler.BackActionHandler
import com.example.registration.store.reducer.RegistrationReducer
import com.example.registration.store.sideeffect.RegistrationSideEffect
import com.example.registration.store.state.RegistrationState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.fabit.udf.store.coroutines.Actors
import ru.fabit.udf.store.coroutines.ErrorHandler
import ru.fabit.udf.store.coroutines.SideEffect
import ru.fabit.udf.store.coroutines.StoreKit


@Module
@InstallIn(ViewModelComponent::class)
object RegistrationStoreModule {
    @Provides
    @ViewModelScoped
    fun provideRegistrationStore(
        errorHandler: ErrorHandler,
        backActionHandler: BackActionHandler,
        registrationSideEffect: RegistrationSideEffect
    ): RegistrationStore {
        return RegistrationStore(
            StoreKit(
                startState = RegistrationState(),
                bootstrapAction = RegistrationAction.Init,
                reducer = RegistrationReducer,
                errorHandler = errorHandler,
                actors = Actors(
                    sideEffects = listOf(registrationSideEffect),
                    bindActionSources = listOf(),
                    actionSources = listOf(),
                    actionHandlers = listOf(
                        backActionHandler
                    )
                )
            )
        )
    }
}