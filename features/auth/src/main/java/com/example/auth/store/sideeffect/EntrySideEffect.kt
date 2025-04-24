package com.example.auth.store.sideeffect

import com.example.auth.store.action.EntryAction
import com.example.auth.store.state.EntryState
import com.example.domain.repository.AuthRepository
import ru.fabit.udf.store.coroutines.SideEffect
import javax.inject.Inject

class EntrySideEffect @Inject constructor(
    authRepository: AuthRepository
): SideEffect<EntryState, EntryAction>(
    query = {_, action ->
        action is EntryAction.Entry
    },
    effect = {state, _ ->
        authRepository.entry(state.login, state.password)
        EntryAction.Init
    },
    error = {EntryAction.Error(it) }
)