package com.example.sharemate.navigation.mediator.chat

import com.example.sharemate.navigation.coordinator.chat.ChatAction
import com.example.sharemate.navigation.coordinator.chat.ChatCoordinator
import com.example.sharemate.navigation.coordinator.chat.ChatListAction
import com.example.sharemate.navigation.coordinator.chat.ChatListCoordinator
import ru.fabit.navigation.Mediator

class ChatListAndChatMediator: Mediator<ChatListCoordinator, ChatCoordinator, ChatListAction, ChatAction>()