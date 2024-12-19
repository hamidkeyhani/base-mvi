plugins {
    id("mvi.android.application")
    id("mvi.android.application.compose")
    id("mvi.android.hilt")
}

android {
    namespace = "com.base.mvi"
    flavorDimensions.add("environment")

    productFlavors {
        create("development") {
            versionCode = 1
            versionName = "1.0.0"
            dimension = "environment"
            applicationId = "com.base.mvi.dev"
        }
        create("stage") {
            versionCode = 1
            versionName = "1.0.0"
            dimension = "environment"
            applicationId = "com.base.mvi.stage"
        }
        create("uat") {
            versionCode = 1
            versionName = "1.0.0"
            dimension = "environment"
            applicationId = "com.base.mvi"
        }
    }

    defaultConfig {
        applicationId = "com.base.mvi"
        // NDK ABI filters for supporting multiple architectures
        externalNativeBuild {
            cmake {
                abiFilters("armeabi-v7a", "x86", "x86_64", "arm64-v8a")
            }
        }
    }

//    signingConfigs {
//        create("debug-sign") {
//            storeFile = rootProject.file("debug-key.keystore")
//            storePassword = "Test123456"
//            keyPassword = "Test123456"
//            keyAlias = "key0"
//        }
//    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            versionNameSuffix = "-debug"
//            signingConfig = signingConfigs.getByName("debug-sign")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            signingConfig = signingConfigs.getByName("debug-sign")
            versionNameSuffix = "-release"
        }

        //change output apk name
        applicationVariants.all {
            outputs.forEach { output ->
                if (output is com.android.build.gradle.internal.api.BaseVariantOutputImpl) {
                    output.outputFileName =
                        "Mvi-plus-v${versionName}(${this.versionCode})-${name}.apk"
                }
            }
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(files("libs/app-react-module.aar"))

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
    implementation(project(":feature:onBoarding"))
    implementation(project(":react-native-module"))
//    implementation(project(":react-native-module"))
//    implementation(project(":core:domain"))
//    implementation(project(":core:data"))
//    implementation(project(":core:sharedApi"))

    implementation(libs.com.google.android.material.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    androidTestImplementation(libs.androidx.navigation.testing)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.timber)
    implementation(libs.kotlinx.coroutines.android)

//    implementation(libs.flipper)
//    implementation(libs.flipperNetwork)
//    implementation(libs.soloader)
    implementation(libs.accompanist.navigation)
    implementation(libs.material)
    implementation(libs.react.native)
}