package com.example.data.mapper

import com.example.data.model.chat.ChatsModel
import com.example.data.model.chat.MessageModel
import com.example.data.model.user.UserModel
import com.example.domain.entity.Chats
import com.example.domain.entity.Message
import com.example.domain.entity.User
import io.realm.kotlin.ext.realmListOf
import javax.inject.Inject

class UserMapper @Inject constructor(
    private val chatsMapper: ChatsMapper
): MapperObject<User, UserModel> {
    override fun transform(objects: User): UserModel =
        UserModel().apply {
            name = objects.name
            email = objects.email
            phone = objects.phone
            chats = realmListOf<ChatsModel>().apply {
                objects.chats.forEach { chats ->
                    chatsMapper.transform(chats)
                }
            }
        }
}

class ChatsMapper @Inject constructor(
    private val messageMapper: MessageMapper
): MapperObject<Chats, ChatsModel> {
    override fun transform(objects: Chats): ChatsModel =
        ChatsModel().apply {
            id = objects.id
            interlocutor = objects.interlocutor
            messageList = realmListOf<MessageModel>().apply {
                objects.messageList.forEach { message ->
                    messageMapper.transform(message)
                }
            }
        }
}

class MessageMapper @Inject constructor(): MapperObject<Message, MessageModel> {
    override fun transform(objects: Message): MessageModel =
        MessageModel().apply {
            text = objects.text
            senderId = objects.senderId
            timestamp = objects.timestamp
        }
}