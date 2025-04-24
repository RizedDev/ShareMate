package com.example.data.mapper

import com.example.data.model.user.UserModel
import com.example.data.model.user.UserResponse
import javax.inject.Inject

class UserResponseMapper @Inject constructor(): MapperObject<UserResponse, UserModel> {
    override fun transform(objects: UserResponse): UserModel =
        UserModel().apply {
            name = objects.name
            email = objects.email
            phone = objects.phone
        }
}