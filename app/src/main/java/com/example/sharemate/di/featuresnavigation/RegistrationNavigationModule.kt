package com.example.sharemate.di.featuresnavigation

import com.example.registration.output.RegistrationOutput
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import com.example.sharemate.navigation.mediator.signin.EntryAndRegistrationMediator
import com.example.sharemate.navigation.mediator.signin.RegistrationAndChatMediator
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegistrationNavigationModule {
    @Singleton
    @Provides
    fun provideRegistrationAndChatMediator(): RegistrationAndChatMediator = RegistrationAndChatMediator()

    @Singleton
    @Provides
    fun provideRegistrationCoordinator(
        entryAndRegistrationMediator: EntryAndRegistrationMediator,
        registrationAndChatMediator: RegistrationAndChatMediator,
        router: Router
    ): RegistrationCoordinator = RegistrationCoordinator(
        entryAndRegistrationMediator,
        registrationAndChatMediator,
        router
    )

    @Singleton
    @Provides
    fun provideRegistrationOutput(
        coordinator: RegistrationCoordinator
    ): RegistrationOutput = coordinator
}