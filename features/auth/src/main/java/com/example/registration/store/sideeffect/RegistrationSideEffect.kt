package com.example.registration.store.sideeffect

import com.example.domain.repository.AuthRepository
import com.example.registration.store.action.RegistrationAction
import com.example.registration.store.state.RegistrationState
import ru.fabit.udf.store.coroutines.SideEffect
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class RegistrationSideEffect @Inject constructor(
    authRepository: AuthRepository
) : SideEffect<RegistrationState, RegistrationAction>(
    query = actionIs<RegistrationAction.Registration>(),
    effect = {state, _ ->
        authRepository.register(state.login, state.password, state.name)
        RegistrationAction.Init
    },
    error = {RegistrationAction.Error(it)}
)