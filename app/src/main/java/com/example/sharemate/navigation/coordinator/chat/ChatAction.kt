package com.example.sharemate.navigation.coordinator.chat

import ru.fabit.navigation.Action

interface ChatAction: Action {
    data class OpenChatScreen(val chatId: String): ChatAction
}