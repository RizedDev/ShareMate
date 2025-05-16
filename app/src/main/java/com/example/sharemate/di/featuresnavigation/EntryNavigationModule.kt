package com.example.sharemate.di.featuresnavigation

import com.example.auth.output.EntryOutput
import com.example.sharemate.navigation.coordinator.signin.entry.EntryCoordinator
import com.example.sharemate.navigation.mediator.signin.EntryAndChatListMediator
import com.example.sharemate.navigation.mediator.signin.EntryAndRegistrationMediator
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EntryNavigationModule {
    @Singleton
    @Provides
    fun provideEntryAndRegistrationMediator(): EntryAndRegistrationMediator = EntryAndRegistrationMediator()

    @Singleton
    @Provides
    fun provideEntryAndChatMediator(): EntryAndChatListMediator = EntryAndChatListMediator()

    @Singleton
    @Provides
    fun provideEntryCoordinator(
        entryAndRegistrationMediator: EntryAndRegistrationMediator,
        entryAndChatListMediator: EntryAndChatListMediator,
        router: Router
    ): EntryCoordinator = EntryCoordinator(
        entryAndRegistrationMediator,
        entryAndChatListMediator,
        router
    )

    @Singleton
    @Provides
    fun provideEntryOutput(
        coordinator: EntryCoordinator
    ):  EntryOutput = coordinator
}