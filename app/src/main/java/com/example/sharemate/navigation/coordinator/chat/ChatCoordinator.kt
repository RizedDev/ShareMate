package com.example.sharemate.navigation.coordinator.chat

import com.example.chat.entry.ChatScreen
import com.example.chat.output.ChatOutput
import com.example.sharemate.navigation.mediator.chat.ChatAndRegistrationMediator
import com.example.sharemate.navigation.mediator.signin.RegistrationAndChatMediator
import com.github.terrakok.cicerone.Router
import ru.fabit.navigation.Action
import ru.fabit.navigation.Coordinator

class ChatCoordinator(
    private val registrationAndChatMediator: RegistrationAndChatMediator,
    private val router: Router
) : Coordinator<ChatAction>, ChatOutput {

    override fun receive(action: Action) {
        when(action) {
            is ChatAction.OpenChatScreen -> openChatScreen()
        }
    }

    override fun register() {
        registrationAndChatMediator.registerAsChildCoordinator(this)
    }

    private fun openChatScreen() {
        router.navigateTo(ChatScreen)
    }
}