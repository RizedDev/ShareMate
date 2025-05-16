package com.example.sharemate.navigation.mediator.chat

import com.example.sharemate.navigation.coordinator.chat.ChatListAction
import com.example.sharemate.navigation.coordinator.chat.ChatListCoordinator
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationAction
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import ru.fabit.navigation.Mediator

class ChatAndRegistrationMediator: Mediator<ChatListCoordinator, RegistrationCoordinator, ChatListAction, RegistrationAction>()