package com.example.auth.store.state

data class AuthState(
    val login: String = "",
    val password: String = "",
    val error: Throwable? = null
)