package com.example.data.service

import com.example.data.model.user.UserResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UserService @Inject constructor(
    private val database: FirebaseDatabase,
    private val firebaseAuth: FirebaseAuth
) {
    fun getUserData(): Flow<UserResponse> = callbackFlow {
        val userUid = firebaseAuth.uid ?: return@callbackFlow
        val userRef: DatabaseReference = database.getReference("users").child(userUid)

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(UserResponse::class.java)!!
                trySend(user)
            }

            override fun onCancelled(error: DatabaseError) {
                close(Exception(error.message))
            }
        }

        userRef.addValueEventListener(listener)

        awaitClose { userRef.removeEventListener(listener) }
    }
}