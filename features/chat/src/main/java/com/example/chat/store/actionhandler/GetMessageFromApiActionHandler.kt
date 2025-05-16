package com.example.chat.store.actionhandler

import com.example.chat.store.action.ChatAction
import com.example.chat.store.state.ChatState
import com.example.domain.repository.ChatRepository
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class GetMessageFromApiActionHandler @Inject constructor(
    chatRepository: ChatRepository
) : ActionHandler<ChatState, ChatAction>(
    query = actionIs<ChatAction.GetMessageFromApi>(),
    handler = {_, action ->
        action as ChatAction.GetMessageFromApi
        chatRepository.getFromApi(action.chatId)
    }
)