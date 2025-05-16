package com.example.sharemate.di.featuresnavigation

import com.example.chat.output.ChatOutput
import com.example.sharemate.navigation.coordinator.chat.ChatCoordinator
import com.example.sharemate.navigation.mediator.chat.ChatListAndChatMediator
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChatNavigationModule {

    @Singleton
    @Provides
    fun provideChatCoordinator(
        chatListAndChatMediator: ChatListAndChatMediator,
        router: Router
    ): ChatCoordinator = ChatCoordinator(
        chatListAndChatMediator,
        router
    )

    @Singleton
    @Provides
    fun provideChatOutput(
        coordinator: ChatCoordinator
    ): ChatOutput = coordinator
}