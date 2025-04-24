package com.example.auth.store.sideeffect

import com.example.auth.store.action.AuthAction
import com.example.auth.store.state.AuthState
import com.example.domain.repository.AuthRepository
import ru.fabit.udf.store.coroutines.SideEffect
import javax.inject.Inject

class EntrySideEffect @Inject constructor(
    authRepository: AuthRepository
): SideEffect<AuthState, AuthAction>(
    query = {_, action ->
        action is AuthAction.Entry
    },
    effect = {state, _ ->
        authRepository.entry(state.login, state.password)
        AuthAction.Init
    },
    error = {AuthAction.Error(it) }
)