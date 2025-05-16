package com.example.data.service

import com.example.data.model.chat.MessageResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ChatService @Inject constructor(
    private val database: FirebaseDatabase,
    private val firebaseAuth: FirebaseAuth
) {
    fun getMessageData(chatId: String): Flow<MessageResponse> = callbackFlow {
        val userUid = firebaseAuth.uid ?: return@callbackFlow
        val chatRef: DatabaseReference =
            database.getReference("users").child(userUid).child("chats").child(chatId)
                .child("messageList")

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val message = snapshot.getValue(MessageResponse::class.java)!!
                trySend(message)
            }

            override fun onCancelled(error: DatabaseError) {
                close(Exception(error.message))
            }
        }

        chatRef.addValueEventListener(listener)

        awaitClose { chatRef.removeEventListener(listener)}
    }
}