package com.example.chatlist.store.actionhandler

import com.example.chatlist.output.ChatListOutput
import com.example.chatlist.store.ActionHandler
import com.example.chatlist.store.ActionSource
import com.example.chatlist.store.action.ChatsListAction
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class OpenChatScreenActionHandler @Inject constructor(
   output: ChatListOutput
): ActionHandler(
    query = actionIs<ChatsListAction.OpenChatScreen>(),
    handler = {_, action ->
        action as ChatsListAction.OpenChatScreen
        output.openChatScreen(action.chatId)
    }
)