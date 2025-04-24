package com.example.chat.entry

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.chat.presentation.ChatFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ChatScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        ChatFragment.newInstance()
}