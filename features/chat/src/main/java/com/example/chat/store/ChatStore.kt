package com.example.chat.store

import com.example.chat.store.action.ChatAction
import com.example.chat.store.state.ChatState
import ru.fabit.udf.store.coroutines.BaseStore
import ru.fabit.udf.store.coroutines.StoreKit

class ChatStore(storeKit: StoreKit<ChatState, ChatAction>) :
        BaseStore<ChatState, ChatAction>(storeKit)