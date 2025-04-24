package com.example.auth.viewcontroller

import com.example.auth.store.EntryStore
import com.example.auth.store.action.EntryAction
import com.example.auth.store.state.EntryState
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.fabit.viewcontroller.coroutines.ViewController
import javax.inject.Inject

@HiltViewModel
class AuthViewController @Inject constructor(
    store: EntryStore
) : ViewController<EntryState, EntryAction>(store) {
    fun openRegisterScreen() {
        dispatchAction(EntryAction.OpenRegisterScreen)
    }

    fun entryFun(login: String, password: String) {
        dispatchAction(EntryAction.Entry(login = login, password = password))
    }
}