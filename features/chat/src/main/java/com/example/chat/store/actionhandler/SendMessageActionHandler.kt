package com.example.chat.store.actionhandler

import com.example.chat.store.action.ChatAction
import com.example.chat.store.state.ChatState
import com.example.domain.repository.ChatRepository
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class SendMessageActionHandler @Inject constructor(
    chatRepository: ChatRepository
): ActionHandler<ChatState, ChatAction>(
    query = actionIs<ChatAction.SendMessage>(),
    handler = {_, action ->
        action as ChatAction.SendMessage
        chatRepository.sendMessage(action.text, action.chatId)
    }
)