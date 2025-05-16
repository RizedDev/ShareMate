package com.example.chatlist.store

import com.example.chatlist.store.action.ChatsListAction
import com.example.chatlist.store.state.ChatsListState
import ru.fabit.udf.store.coroutines.ActionHandler
import ru.fabit.udf.store.coroutines.ActionSource
import ru.fabit.udf.store.coroutines.BaseStore
import ru.fabit.udf.store.coroutines.BindActionSource
import ru.fabit.udf.store.coroutines.Reducer
import ru.fabit.udf.store.coroutines.SideEffect
import ru.fabit.udf.store.coroutines.StoreKit

typealias Reducer = Reducer<ChatsListState, ChatsListAction>
typealias ActionHandler = ActionHandler<ChatsListState, ChatsListAction>
typealias BindActionSource = BindActionSource<ChatsListState, ChatsListAction>
typealias ActionSource = ActionSource<ChatsListAction>
typealias SideEffect = SideEffect<ChatsListState, ChatsListAction>

class ChatsListStore(storeKit: StoreKit<ChatsListState, ChatsListAction>) :
    BaseStore<ChatsListState, ChatsListAction>(storeKit)