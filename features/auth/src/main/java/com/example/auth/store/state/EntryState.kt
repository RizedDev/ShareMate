package com.example.auth.store.state

data class EntryState(
    val login: String = "",
    val password: String = "",
    val error: Throwable? = null
)