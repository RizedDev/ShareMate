package com.example.auth.entry

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.auth.presentation.EntryFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object EntryScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        EntryFragment.newInstance()
}