package com.example.auth.store.actionhandler

import com.example.auth.output.EntryOutput
import com.example.auth.store.action.EntryAction
import com.example.auth.store.state.EntryState
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class OpenChatScreenActionHandler @Inject constructor(
    output: EntryOutput
) : ActionHandler<EntryState, EntryAction>(
    query = actionIs<EntryAction.OpenChatScreen>(),
    handler = {_, _ ->
        output.openChatScreen()
    }
)