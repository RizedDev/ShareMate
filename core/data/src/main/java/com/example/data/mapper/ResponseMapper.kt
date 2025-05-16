package com.example.data.mapper

import com.example.data.model.chat.ChatsModel
import com.example.data.model.chat.ChatsResponse
import com.example.data.model.chat.MessageModel
import com.example.data.model.chat.MessageResponse
import com.example.data.model.user.UserModel
import com.example.data.model.user.UserResponse
import io.realm.kotlin.ext.realmListOf
import javax.inject.Inject

class UserResponseMapper @Inject constructor(
    private val chatsResponseMapper: ChatsResponseMapper
): MapperObject<UserResponse, UserModel> {
    override fun transform(objects: UserResponse): UserModel =
        UserModel().apply {
            name = objects.name
            email = objects.email
            phone = objects.phone
            chats = realmListOf<ChatsModel>().apply {
                objects.chats.map {
                    add(chatsResponseMapper.transform(it))
                }
            }
        }
}

class MessageResponseMapper @Inject constructor(): MapperObject<MessageResponse, MessageModel> {
    override fun transform(objects: MessageResponse): MessageModel =
        MessageModel().apply {
            text = objects.text
            senderId = objects.senderId
            timestamp = objects.timestamp
        }
}

class ChatsResponseMapper @Inject constructor(
    private val messageResponseMapper: MessageResponseMapper
): MapperObject<ChatsResponse, ChatsModel> {
    override fun transform(objects: ChatsResponse): ChatsModel =
        ChatsModel().apply {
            id = objects.id
            interlocutor = objects.interlocutor
            messageList = realmListOf<MessageModel>().apply {
                objects.messageList.map {
                    add(messageResponseMapper.transform(it))
                }
            }
        }
}