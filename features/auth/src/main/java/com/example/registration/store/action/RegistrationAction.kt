package com.example.registration.store.action

interface RegistrationAction {
    data object Init: RegistrationAction
    data object Back: RegistrationAction
    data object OpenChatScreen: RegistrationAction

    data class Registration(val email: String, val password: String, val name: String): RegistrationAction
    data class Error(val t: Throwable): RegistrationAction
}