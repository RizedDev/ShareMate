package com.example.data.mapper

import com.example.data.model.user.UserModel
import com.example.domain.entity.User
import javax.inject.Inject

class UserMapper @Inject constructor(): MapperObject<User, UserModel> {
    override fun transform(objects: User): UserModel =
        UserModel().apply {
            name = objects.name
            email = objects.email
            phone = objects.phone
        }

}