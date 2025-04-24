package com.example.registration.store.state

data class RegistrationState(
    val name: String = "",
    val login: String = "",
    val password: String = "",
    val errorRegistration: Throwable? = null
)