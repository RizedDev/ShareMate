package com.example.data.repositoryimpl

import com.example.data.mapper.MessageModelMapper
import com.example.data.mapper.MessageResponseMapper
import com.example.data.model.chat.MessageModel
import com.example.data.service.ChatService
import com.example.domain.entity.Message
import com.example.domain.repository.ChatRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import io.realm.kotlin.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val database: FirebaseDatabase,
    private val responceMapper: MessageResponseMapper,
    private val firebaseAuth: FirebaseAuth,
    private val chatService: ChatService,
    modelMapper: MessageModelMapper,
    realm: Realm
) : ChatRepository, BaseRealmRepository<MessageModel, Message>(realm, modelMapper) {
    override suspend fun getFromApi(chatId: String) {
        chatService.getMessageData(chatId).collect {
            val messageModel = responceMapper.transform(it)
            addToDataBase(messageModel)
        }
    }

    override suspend fun getDataBase(): Flow<Message?> {
        return getFromIdDatabase<MessageModel>(0)
    }

    override suspend fun updateMessage(message: Message) {

    }

    override suspend fun sendMessage(text: String, chatId: String) {
        val userUid = firebaseAuth.uid!!
        database.reference.child("users").child(userUid).child("chats").child(chatId)
            .child("messageList").child("text").setValue(text)
    }

}