package com.example.auth.store.reducer

import com.example.auth.store.action.EntryAction
import com.example.auth.store.state.EntryState
import ru.fabit.udf.store.coroutines.Reducer

object AuthReducer : Reducer<EntryState, EntryAction> {
    override fun EntryState.reduce(action: EntryAction): EntryState {
        return when (action) {
            is EntryAction.Entry -> copy(
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