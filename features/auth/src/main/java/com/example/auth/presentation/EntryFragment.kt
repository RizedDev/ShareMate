package com.example.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.auth.databinding.FragmentAuthBinding
import com.example.auth.store.state.EntryState
import com.example.auth.viewcontroller.AuthViewController
import dagger.hilt.android.AndroidEntryPoint
import ru.fabit.viewcontroller.core.StateView
import ru.fabit.viewcontroller.coroutines.registerViewController
import ru.fabit.viewcontroller.coroutines.viewControllers

@AndroidEntryPoint
class EntryFragment : Fragment(), StateView<EntryState> {

    private val viewController: AuthViewController by viewControllers()
    private lateinit var binding: FragmentAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewController(viewController)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonInit()
    }

    override fun renderState(state: EntryState, payload: Any?) {

    }

    private fun buttonInit() {
        binding.apply {
            entry.setOnClickListener {
                viewController.entryFun(
                    binding.login.text.toString(),
                    binding.password.text.toString()
                )
            }

            register.setOnClickListener {
                viewController.openRegisterScreen()
            }
        }
    }


    companion object {
        fun newInstance(): EntryFragment = EntryFragment()
    }
}