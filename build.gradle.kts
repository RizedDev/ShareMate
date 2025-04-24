// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.io.realm.kotlin) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
    kotlin("plugin.serialization") version "1.9.0"
    alias(libs.plugins.google.gms.google.services) apply false

}

buildscript {
    dependencies {
        classpath(libs.kotlin.serialization)
        classpath(libs.kotlin.gradle.plugin)
    }
}
