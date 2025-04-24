package com.example.data.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
)
