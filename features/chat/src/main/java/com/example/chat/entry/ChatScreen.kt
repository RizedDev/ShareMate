package com.example.chat.entry

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.chat.presentation.ChatFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ChatScreen(private val chatId: String): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        ChatFragment.newInstance(chatId)
}