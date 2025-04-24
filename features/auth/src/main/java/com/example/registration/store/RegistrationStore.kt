package com.example.registration.store

import com.example.registration.store.action.RegistrationAction
import com.example.registration.store.state.RegistrationState
import ru.fabit.udf.store.coroutines.BaseStore
import ru.fabit.udf.store.coroutines.StoreKit

class RegistrationStore(
    storeKit: StoreKit<RegistrationState, RegistrationAction>
) : BaseStore<RegistrationState, RegistrationAction>(storeKit)