package com.example.sharemate.di

import com.example.sharemate.navigation.StartNavigation
import com.example.sharemate.navigation.coordinator.chat.ChatCoordinator
import com.example.sharemate.navigation.coordinator.signin.entry.EntryCoordinator
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.fabit.navigation.registration.CoordinatorRegistration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {
    @Singleton
    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Singleton
    @Provides
    fun provideNavigationHolder(
        cicerone: Cicerone<Router>
    ): NavigatorHolder =
        cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun provideStartNavigation(
        firebaseAuth: FirebaseAuth,
        router: Router
    ): StartNavigation {
        return StartNavigation(firebaseAuth, router)
    }

    @Singleton
    @Provides
    fun provideApplicationCoordinatorRegistration(
        entryCoordinator: EntryCoordinator,
        registrationCoordinator: RegistrationCoordinator,
        chatCoordinator: ChatCoordinator
    ): CoordinatorRegistration {
        return CoordinatorRegistration(
            entryCoordinator,
            registrationCoordinator,
            chatCoordinator
        )
    }
}