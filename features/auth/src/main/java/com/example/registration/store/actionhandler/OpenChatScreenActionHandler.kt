package com.example.registration.store.actionhandler

import com.example.registration.output.RegistrationOutput
import com.example.registration.store.action.RegistrationAction
import com.example.registration.store.state.RegistrationState
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class OpenChatScreenActionHandler @Inject constructor(
    output: RegistrationOutput
) : ActionHandler<RegistrationState, RegistrationAction> (
    query = actionIs<RegistrationAction.OpenChatScreen>(),
    handler = {_, _ ->
        output.openChatScreen()
    }
)