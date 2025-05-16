package com.example.chat.store.actionsource

import com.example.chat.store.action.ChatAction
import com.example.chat.store.state.ChatState
import com.example.domain.repository.ChatRepository
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class GetMessageFromDataBaseActionSource @Inject constructor(
    chatRepository: ChatRepository
) : ActionHandler<ChatState, ChatAction>(
    query = actionIs<ChatAction.Init>(),
    handler = {_, _ ->
        chatRepository.getDataBase()
    }
)