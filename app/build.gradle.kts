@file:Suppress("UnstableApiUsage")
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.mapsplatform.secrets.gradle.plugin)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    kotlin("kapt")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.schooliraha.irahaschool"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.schooliraha.irahaschool"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName ="1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        targetCompatibility =JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes +="/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Jetpack Core
    implementation(libs.bundles.androidx)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.accompanist)
    implementation(libs.timber)
    implementation(libs.bundles.lifecycle)
    implementation("androidx.test:monitor:1.6.1")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("junit:junit:4.12")
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Color-Extraction-Pallet
    implementation(libs.color.extraction)
    implementation(libs.lottie)

    // core library desugaring
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    coreLibraryDesugaring(libs.desugar.jdk.desugar)

    // The compose calendar library
    implementation("com.kizitonwose.calendar:compose:2.3.0")

    // Kotlin stdlib
    implementation(libs.kotlin.stdlib)

    // Google Play Services
    implementation(libs.playservices.location)

    // Data & Async
    implementation(libs.retrofit)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.converter)
    implementation(libs.kotlinx.serialization)
    implementation(libs.coil)
    implementation(kotlin("reflect"))

    // DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase)

    // Test
    testImplementation(libs.junit)
    testImplementation(libs.turbine)
    testImplementation(libs.mock.android)
    testImplementation(libs.mock.agent)
    testImplementation(libs.truth)
    testImplementation(libs.coroutines.test)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)


    // Chucker
    debugImplementation(libs.chucker.debug)
    releaseImplementation(libs.chucker.release)
}

kapt {
    correctErrorTypes = true
}