package com.example.registration.entry

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.auth.presentation.EntryFragment
import com.example.registration.presentation.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object RegistrationScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        RegistrationFragment.newInstance()
}