package com.example.auth.store.actionhandler

import com.example.auth.output.EntryOutput
import com.example.auth.store.action.EntryAction
import com.example.auth.store.state.EntryState
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class OpenRegisterScreenActionHandler @Inject constructor(
    outPut: EntryOutput
): ActionHandler<EntryState, EntryAction>(
    query = actionIs<EntryAction.OpenRegisterScreen>(),
    handler = {_,_ ->
        outPut.openRegisterScreen()
    }
)