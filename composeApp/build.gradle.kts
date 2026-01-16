import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    //https://kotlinlang.org/docs/serialization.html#example-json-serialization
    alias(libs.plugins.serialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // https://ktor.io/docs/client-create-multiplatform-application.html#ktor-dependencies
            implementation(libs.ktor.client.okhttp)

            // https://ktor.io/docs/client-create-multiplatform-application.html#ktor-dependencies
            implementation(libs.kotlinx.coroutines.android)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // https://kotlinlang.org/docs/multiplatform/compose-navigation.html
            implementation(libs.navigation.compose)

            // https://kotlinlang.org/docs/serialization.html#serialize-and-deserialize-json
            implementation(libs.kotlinx.serialization.json)

            // https://ktor.io/docs/client-create-multiplatform-application.html#ktor-dependencies
            implementation(libs.ktor.client.core)

            // https://ktor.io/docs/client-create-multiplatform-application.html#ktor-dependencies
            implementation(libs.kotlinx.coroutines.core)

            // https://ktor.io/docs/client-serialization.html#serialization_dependency
            implementation(libs.ktor.content.negotiation)

            // https://ktor.io/docs/client-serialization.html#serialization_dependency
            implementation(libs.ktor.serialization.json)

            // https://ktor.io/docs/client-auth.html#install_plugin
            implementation(libs.ktor.client.auth)

            // https://ktor.io/docs/client-logging.html#multiplatform
            implementation(libs.ktor.client.logging)

            // https://github.com/coil-kt/coil
            implementation(libs.coil.network.ktor3)
            implementation(libs.coil.compose)

            // https://insert-koin.io/docs/setup/koin/#jetpack-compose-or-compose-multiplatform
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)
            implementation(libs.koin.core)

            // https://klibs.io/project/devsrsouza/compose-icons
            implementation(libs.composeIcons.fontAwesome)

            // https://github.com/Kotlin/kotlinx-datetime
            implementation(libs.kotlinx.datetime)
        }
        iosMain.dependencies {
            // https://ktor.io/docs/client-create-multiplatform-application.html#ktor-dependencies
            implementation(libs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.movies"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.movies"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

