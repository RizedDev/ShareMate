package com.example.auth.store.actionhandler

import com.example.auth.output.EntryOutput
import com.example.auth.store.action.AuthAction
import com.example.auth.store.state.AuthState
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class OpenRegisterScreenActionHandler @Inject constructor(
    outPut: EntryOutput
): ActionHandler<AuthState, AuthAction>(
    query = actionIs<AuthAction.OpenRegisterScreen>(),
    handler = {_,_ ->
        outPut.openRegisterScreen()
    }
)