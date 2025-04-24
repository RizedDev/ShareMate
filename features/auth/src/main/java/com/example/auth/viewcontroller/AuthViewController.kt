package com.example.auth.viewcontroller

import com.example.auth.store.AuthStore
import com.example.auth.store.action.AuthAction
import com.example.auth.store.state.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.fabit.viewcontroller.coroutines.ViewController
import javax.inject.Inject

@HiltViewModel
class AuthViewController @Inject constructor(
    store: AuthStore
) : ViewController<AuthState, AuthAction>(store) {
    fun openRegisterScreen() {
        dispatchAction(AuthAction.OpenRegisterScreen)
    }

    fun entryFun(login: String, password: String) {
        dispatchAction(AuthAction.Entry(login = login, password = password))
    }
}