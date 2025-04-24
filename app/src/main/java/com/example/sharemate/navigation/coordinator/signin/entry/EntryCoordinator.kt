package com.example.sharemate.navigation.coordinator.signin.entry

import com.example.auth.entry.EntryScreen
import com.example.auth.output.EntryOutput
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationAction
import com.example.sharemate.navigation.mediator.signin.EntryAndRegistrationMediator
import com.github.terrakok.cicerone.Router
import ru.fabit.navigation.Action
import ru.fabit.navigation.Coordinator

class EntryCoordinator(
    private val entryAndRegistrationMediator: EntryAndRegistrationMediator,
    private val router: Router
) : Coordinator<EntryAction>, EntryOutput {

    override fun receive(action: Action) {
        when(action) {
            is EntryAction.OpenEntryScreen -> openEntryScreen()
        }
    }

    override fun register() {
        entryAndRegistrationMediator.registerAsParentCoordinator(this)
    }

    override fun openEntryScreen() {
        router.navigateTo(EntryScreen)
    }

    override fun openRegisterScreen() {
        entryAndRegistrationMediator.sendToChild(RegistrationAction.OpenRegistrationScreen)
    }


}