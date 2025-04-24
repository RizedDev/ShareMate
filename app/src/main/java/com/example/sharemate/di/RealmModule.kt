package com.example.sharemate.di

import com.example.data.model.user.UserModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RealmModule {
    @Singleton
    @Provides
    fun provideRealm(): Realm =
        Realm.open(
            RealmConfiguration.Builder(
                schema = setOf(
                    UserModel::class
                )
            )
                .schemaVersion(2L)
                .build()
        )
}