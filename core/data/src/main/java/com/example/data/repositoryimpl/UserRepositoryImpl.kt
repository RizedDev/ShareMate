package com.example.data.repositoryimpl

import com.example.data.mapper.UserModelMapper
import com.example.data.mapper.UserResponseMapper
import com.example.data.model.user.UserModel
import com.example.data.service.UserService
import com.example.domain.entity.Chats
import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import io.realm.kotlin.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val responseMapper: UserResponseMapper,
    private val firebaseAuth: FirebaseAuth,
    private val database: FirebaseDatabase,
    modelMapper: UserModelMapper,
    realm: Realm
) : UserRepository, BaseRealmRepository<UserModel, User>(realm, modelMapper) {
    override suspend fun getFromApi() {
        userService.getUserData().collect {
            val userModel = responseMapper.transform(it)
            addToDataBase(userModel)
        }
    }

    override suspend fun getDatabase(): Flow<User?> {
        return getFromIdDatabase<UserModel>(0)
    }

    override suspend fun updateUser(user: User) {
        val userUid = firebaseAuth.uid!!
        database.reference.child("users").child(userUid).setValue(user).await()
    }

    override suspend fun updateChats(chats: Chats) {
        val userUid = firebaseAuth.uid!!
        database.reference.child("users").child(userUid).child("chats").setValue(chats).await()
    }
}
