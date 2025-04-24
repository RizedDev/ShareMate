package com.example.auth.store.reducer

import com.example.auth.store.action.AuthAction
import com.example.auth.store.state.AuthState
import ru.fabit.udf.store.coroutines.Reducer

object AuthReducer : Reducer<AuthState, AuthAction> {
    override fun AuthState.reduce(action: AuthAction): AuthState {
        return when (action) {
            is AuthAction.Entry -> copy(
                login = action.login,
                password = action.password
            )

//            is AuthAction.Error -> copy(
//                errorEntry = action.t
//            )

            else -> copy()
        }
    }
}