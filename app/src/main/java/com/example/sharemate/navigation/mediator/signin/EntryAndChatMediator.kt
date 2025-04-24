package com.example.sharemate.navigation.mediator.signin

import com.example.sharemate.navigation.coordinator.chat.ChatAction
import com.example.sharemate.navigation.coordinator.chat.ChatCoordinator
import com.example.sharemate.navigation.coordinator.signin.entry.EntryAction
import com.example.sharemate.navigation.coordinator.signin.entry.EntryCoordinator
import ru.fabit.navigation.Mediator

class EntryAndChatMediator: Mediator<EntryCoordinator, ChatCoordinator, EntryAction, ChatAction>()