package com.example.sharemate.navigation

import com.example.auth.entry.EntryScreen
import com.example.chatlist.entry.ChatListScreen
import com.github.terrakok.cicerone.Router
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class StartNavigation @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val router: Router
) {
    fun start() {
        if (firebaseAuth.currentUser == null) router.newRootScreen(EntryScreen)
        else router.newRootScreen(ChatListScreen)
    }
}