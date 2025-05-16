package com.example.chatlist.store.actionhandler

import com.example.chatlist.store.ActionHandler
import com.example.chatlist.store.action.ChatsListAction
import com.example.domain.repository.UserRepository
import ru.fabit.udf.store.coroutines.actionIs
import javax.inject.Inject

class GetUserFromApiActionHandler @Inject constructor(
    userRepository: UserRepository
) : ActionHandler(
    query = actionIs<ChatsListAction.Init>(),
    handler = { _, _ ->
        userRepository.getFromApi()
    }
)
