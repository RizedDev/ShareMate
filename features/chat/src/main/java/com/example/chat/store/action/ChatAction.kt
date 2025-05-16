package com.example.chat.store.action

sealed interface ChatAction {
    data object Init: ChatAction
    data object Back: ChatAction

    data class GetMessageFromApi(val chatId: String): ChatAction
    data class Error(val t: Throwable): ChatAction
    data class SendMessage(val text: String, val chatId: String): ChatAction
}