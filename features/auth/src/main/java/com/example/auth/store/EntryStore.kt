package com.example.auth.store

import com.example.auth.store.action.EntryAction
import com.example.auth.store.state.EntryState
import ru.fabit.udf.store.coroutines.BaseStore
import ru.fabit.udf.store.coroutines.StoreKit

class EntryStore(
    storeKit: StoreKit<EntryState, EntryAction>
): BaseStore<EntryState, EntryAction>(storeKit)