package com.example.sharemate.navigation.mediator.signin

import com.example.sharemate.navigation.coordinator.chat.ChatListAction
import com.example.sharemate.navigation.coordinator.chat.ChatListCoordinator
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationAction
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import ru.fabit.navigation.Mediator

class RegistrationAndChatListMediator: Mediator<RegistrationCoordinator, ChatListCoordinator, RegistrationAction, ChatListAction>()