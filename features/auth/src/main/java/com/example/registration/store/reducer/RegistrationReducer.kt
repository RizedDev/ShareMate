package com.example.registration.store.reducer

import com.example.registration.store.action.RegistrationAction
import com.example.registration.store.state.RegistrationState
import ru.fabit.udf.store.coroutines.Reducer

object RegistrationReducer: Reducer<RegistrationState, RegistrationAction> {
    override fun RegistrationState.reduce(action: RegistrationAction): RegistrationState {
        return when (action) {
            is RegistrationAction.Registration -> copy(
                login = action.email,
                password = action.password,
                name = action.name
            )

            is RegistrationAction.Error -> copy(
                errorRegistration = action.t
            )

            else -> copy()
        }
    }

}