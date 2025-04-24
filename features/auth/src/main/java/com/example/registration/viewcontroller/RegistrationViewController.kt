package com.example.registration.viewcontroller

import com.example.registration.store.RegistrationStore
import com.example.registration.store.action.RegistrationAction
import com.example.registration.store.state.RegistrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.fabit.viewcontroller.coroutines.ViewController
import javax.inject.Inject

@HiltViewModel
class RegistrationViewController @Inject constructor(
    store: RegistrationStore
) : ViewController<RegistrationState, RegistrationAction>(store) {
    fun back() {
        dispatchAction(RegistrationAction.Back)
    }

    fun registrationFun(login: String, password: String, name: String){
        dispatchAction(RegistrationAction.Registration(login, password, name))
    }
}