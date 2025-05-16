package com.example.registration.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.example.auth.R
import com.example.auth.databinding.FragmentRegistrationBinding
import com.example.registration.store.state.RegistrationState
import com.example.registration.viewcontroller.RegistrationViewController
import dagger.hilt.android.AndroidEntryPoint
import ru.fabit.viewcontroller.core.StateView
import ru.fabit.viewcontroller.coroutines.registerViewController
import ru.fabit.viewcontroller.coroutines.viewControllers

@AndroidEntryPoint
class RegistrationFragment : Fragment(), StateView<RegistrationState> {
    private lateinit var binding: FragmentRegistrationBinding
    private val viewController: RegistrationViewController by viewControllers()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewController(viewController)

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewController.back()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonInit()
    }

    override fun renderState(state: RegistrationState, payload: Any?) {

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun buttonInit(){
        binding.apply {
            register.setOnClickListener {
                viewController.registrationFun(
                    binding.login.text.toString(),
                    binding.password.text.toString(),
                    binding.name.text.toString()
                )
            }
        }

        binding.entry.setOnClickListener {
            viewController.back()
        }
    }

    companion object {
        fun newInstance(): RegistrationFragment = RegistrationFragment()
    }
}