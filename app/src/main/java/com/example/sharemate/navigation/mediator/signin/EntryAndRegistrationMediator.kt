package com.example.sharemate.navigation.mediator.signin

import com.example.sharemate.navigation.coordinator.signin.entry.EntryAction
import com.example.sharemate.navigation.coordinator.signin.entry.EntryCoordinator
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationAction
import com.example.sharemate.navigation.coordinator.signin.registration.RegistrationCoordinator
import ru.fabit.navigation.Mediator


class EntryAndRegistrationMediator: Mediator<EntryCoordinator, RegistrationCoordinator, EntryAction, RegistrationAction>()