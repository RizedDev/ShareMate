package com.example.auth.store

import com.example.auth.store.action.AuthAction
import com.example.auth.store.state.AuthState
import ru.fabit.udf.store.coroutines.BaseStore
import ru.fabit.udf.store.coroutines.StoreKit

class AuthStore(
    storeKit: StoreKit<AuthState, AuthAction>
): BaseStore<AuthState, AuthAction>(storeKit)