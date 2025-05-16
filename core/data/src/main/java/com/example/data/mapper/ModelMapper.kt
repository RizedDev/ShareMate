package com.example.data.mapper

import com.example.data.model.chat.ChatsModel
import com.example.data.model.chat.MessageModel
import com.example.data.model.user.UserModel
import com.example.domain.entity.Chats
import com.example.domain.entity.Message
import com.example.domain.entity.User
import javax.inject.Inject

class UserModelMapper @Inject constructor(
    private val chatsModelMapper: ChatsModelMapper
): MapperObject<UserModel, User> {
    override fun transform(objects: UserModel): User =
        User(
            name = objects.name,
            email = objects.email,
            phone = objects.phone,
            chats = objects.chats.map {
                chatsModelMapper.transform(it)
            }
        )
}

class MessageModelMapper @Inject constructor(): MapperObject<MessageModel, Message> {
    override fun transform(objects: MessageModel): Message =
        Message(
            text = objects.text,
            senderId = objects.senderId,
            timestamp = objects.timestamp
        )
}

class ChatsModelMapper @Inject constructor(
    private val messageModelMapper: MessageModelMapper
): MapperObject<ChatsModel, Chats> {
    override fun transform(objects: ChatsModel): Chats =
        Chats(
            id = objects.id,
            interlocutor = objects.interlocutor,
            messageList = objects.messageList.map {
                messageModelMapper.transform(it)
            }
        )
}