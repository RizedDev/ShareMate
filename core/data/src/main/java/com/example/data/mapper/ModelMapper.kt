package com.example.data.mapper

import com.example.data.model.user.UserModel
import com.example.domain.entity.User
import javax.inject.Inject

class UserModelMapper @Inject constructor(): MapperObject<UserModel, User> {
    override fun transform(objects: UserModel): User =
        User(
            name = objects.name,
            email = objects.email,
            phone = objects.phone
        )
}