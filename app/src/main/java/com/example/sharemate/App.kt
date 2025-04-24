package com.example.sharemate

import android.app.Application
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import ru.fabit.navigation.registration.CoordinatorRegistration
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var coordinatorRegistration: CoordinatorRegistration

    override fun onCreate() {
        super.onCreate()

        coordinatorRegistration.register()
    }
}