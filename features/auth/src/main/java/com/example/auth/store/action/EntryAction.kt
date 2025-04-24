package com.example.auth.store.action

sealed interface EntryAction {
    data object Init: EntryAction
    data object OpenRegisterScreen: EntryAction
    data object OpenChatScreen: EntryAction

    data class Error(val t: Throwable): EntryAction
    data class Entry(val login: String, val password: String): EntryAction
}