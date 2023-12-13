plugins {
    id("taraftarplus.android.library")
    id("taraftarplus.android.hilt")
}

android {
    namespace = "com.fourplay.datastore"
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.dataStore.core)
    implementation(libs.protobuf.kotlin.lite)
    implementation(libs.serializationJson)
}