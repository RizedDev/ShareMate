package com.example.chatlist.store.actionsource

import com.example.chatlist.store.ActionSource
import com.example.chatlist.store.action.ChatsListAction
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserFromDataBaseActionSource @Inject constructor(
    userRepository: UserRepository
) : ActionSource(
    source = {
        userRepository.getDatabase().map {
            if (it != null) {
                ChatsListAction.GetUserData(it, it.chats)
            }
            else ChatsListAction.Error(Throwable("User data not found"))
        }
    },
    error = { ChatsListAction.Error(it) }
)
