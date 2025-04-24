package com.example.auth.store.action

sealed interface AuthAction {
    data object Init: AuthAction
    data object OpenRegisterScreen: AuthAction

    data class Error(val t: Throwable): AuthAction
    data class Entry(val login: String, val password: String): AuthAction
}