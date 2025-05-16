package com.example.sharemate.navigation.mediator.signin

import com.example.sharemate.navigation.coordinator.chat.ChatListAction
import com.example.sharemate.navigation.coordinator.chat.ChatListCoordinator
import com.example.sharemate.navigation.coordinator.signin.entry.EntryAction
import com.example.sharemate.navigation.coordinator.signin.entry.EntryCoordinator
import ru.fabit.navigation.Mediator

class EntryAndChatListMediator: Mediator<EntryCoordinator, ChatListCoordinator, EntryAction, ChatListAction>()