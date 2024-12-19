plugins {
    id("mvi.android.library")
    id("mvi.android.hilt")
}

android {
    namespace = "com.base.datastore"
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.dataStore.core)
    implementation(libs.protobuf.kotlin.lite)
    implementation(libs.serializationJson)
}