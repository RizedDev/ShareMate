package com.example.data.repositoryimpl

import com.example.data.mapper.UserModelMapper
import com.example.data.model.user.UserModel
import com.example.domain.entity.User
import com.example.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.database.FirebaseDatabase
import io.realm.kotlin.Realm
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private var firebaseAuth: FirebaseAuth,
    private val dataBase: FirebaseDatabase,
    modelMapper: UserModelMapper,
    realm: Realm
): AuthRepository, BaseRealmRepository<UserModel, User>(realm, modelMapper) {
    override suspend fun entry(email: String, password: String) {
        try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
        } catch (e: Exception) {
            when (e) {
                is FirebaseAuthInvalidUserException -> {
                    throw Throwable("Проверьте адресс электронной почты")
                }

                is FirebaseAuthInvalidCredentialsException -> {
                    throw Throwable("Неверные данные пользователя")
                }

                else -> {
                    throw Throwable("Ошибка входа: ${e.message}")
                }
            }
        }
    }

    override suspend fun register(email: String, password: String, name: String) {
        try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val userId = authResult.user?.uid

            userId?.let {
                val userData = User(
                    name = name,
                    email = email,
                    phone = "",
                    chats = listOf()
                )

                dataBase.reference.child("users").child(it).setValue(userData).await()
            }
        } catch (e: Exception) {
            when (e) {
                is FirebaseAuthUserCollisionException -> {
                    throw Throwable("Пользователь с таким email уже существует.")
                }

                else -> {
                    throw Throwable("Ошибка регистрации: ${e.message}")
                }
            }
        }
    }


    override suspend fun exit() {
        try {
            deleteFromDataBase<UserModel>(0)
            firebaseAuth.signOut()
        }catch (e: Exception){
            throw Exception("Ошибка: ${e.message}")
        }
    }


}