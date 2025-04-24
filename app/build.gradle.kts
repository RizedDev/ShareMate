plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.sharemate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sharemate"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":features:auth"))
    implementation(project(":features:chat"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.work)

    implementation(libs.library.navigation)
    implementation(libs.viewcontroller.coroutines)
    implementation(libs.gentleman)

    implementation(libs.mapkit)

    implementation(libs.location)

    implementation(libs.cicerone)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation (libs.hilt.work)
    kapt (libs.hilt.androidx.compiler)

    implementation(libs.realm.base)
    implementation(libs.realm.sync)

    implementation(libs.coroutines)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.reactive)

    implementation(libs.androidx.fragment.ktx)

    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)

    implementation(libs.androidx.core.splashscreen)

}

kapt {
    correctErrorTypes = true
}