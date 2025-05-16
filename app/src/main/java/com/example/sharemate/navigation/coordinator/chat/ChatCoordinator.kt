package com.example.sharemate.navigation.coordinator.chat

import com.example.chat.entry.ChatScreen
import com.example.chat.output.ChatOutput
import com.example.sharemate.navigation.mediator.chat.ChatListAndChatMediator
import com.github.terrakok.cicerone.Router
import ru.fabit.navigation.Action
import ru.fabit.navigation.Coordinator

class ChatCoordinator(
    private val chatListAndChatMediator: ChatListAndChatMediator,
    private val router: Router
) : Coordinator<ChatAction>, ChatOutput {
    override fun receive(action: Action) {
        when(action) {
            is ChatAction.OpenChatScreen -> openChatScreen(action.chatId)
        }
    }

    override fun register() {
        chatListAndChatMediator.registerAsChildCoordinator(this)
    }

    override fun back() {
        router.exit()
    }

    private fun openChatScreen(chatId: String) {
        router.navigateTo(ChatScreen(chatId))
    }

}