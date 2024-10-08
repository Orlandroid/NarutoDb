import com.example.androidbase.presentation.ConfigData
import com.example.androidbase.presentation.Dependencies
import com.example.androidbase.presentation.room

plugins {
    id("com.android.library")
    kotlin("kapt")
    kotlin("android")
    kotlin("plugin.serialization")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.domain"
    compileSdk = ConfigData.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ConfigData.MIN_SDK_VERSION
        targetSdk = ConfigData.TARGET_SDK_VERSION

        testInstrumentationRunner = ConfigData.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(Dependencies.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.ANDROID_MATERIAL)
    testImplementation(Dependencies.JUNIT_JUNIT)
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    room()
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
}