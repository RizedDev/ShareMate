package com.example.sharemate.navigation.mediator.chat

import com.example.sharemate.navigation.coordinator.chat.ChatAction
import com.example.sharemate.navigation.coordinator.chat.ChatCoordinator
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationAction
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import ru.fabit.navigation.Mediator

class ChatAndRegistrationMediator: Mediator<ChatCoordinator, RegistrationCoordinator, ChatAction, RegistrationAction>()