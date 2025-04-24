package com.example.sharemate.navigation.mediator.signin

import com.example.sharemate.navigation.coordinator.chat.ChatAction
import com.example.sharemate.navigation.coordinator.chat.ChatCoordinator
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationAction
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import ru.fabit.navigation.Mediator

class RegistrationAndChatMediator: Mediator<RegistrationCoordinator, ChatCoordinator, RegistrationAction, ChatAction>()