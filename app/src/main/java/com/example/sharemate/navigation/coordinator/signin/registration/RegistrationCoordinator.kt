package com.example.sharemate.navigation.coordinator.signin.registration

import com.example.registration.entry.RegistrationScreen
import com.example.registration.output.RegistrationOutput
import com.example.sharemate.navigation.coordinator.chat.ChatListAction
import com.example.sharemate.navigation.mediator.signin.EntryAndRegistrationMediator
import com.example.sharemate.navigation.mediator.signin.RegistrationAndChatListMediator
import com.github.terrakok.cicerone.Router
import ru.fabit.navigation.Action
import ru.fabit.navigation.Coordinator

class RegistrationCoordinator(
    private val entryAndRegistrationMediator: EntryAndRegistrationMediator,
    private val registrationAndChatListMediator: RegistrationAndChatListMediator,
    private val router: Router
) : Coordinator<RegistrationAction>, RegistrationOutput{

    override fun receive(action: Action) {
        when(action) {
            is RegistrationAction.OpenRegistrationScreen -> openRegistrationScreen()
        }
    }
    override fun register() {
        entryAndRegistrationMediator.registerAsChildCoordinator(this)
        registrationAndChatListMediator.registerAsParentCoordinator(this)
    }

    private fun openRegistrationScreen(){
        router.navigateTo(RegistrationScreen)
    }

    override fun back() {
        router.exit()
    }

    override fun openChatScreen() {
        registrationAndChatListMediator.sendToChild(ChatListAction.OpenChatListScreen)
    }

}