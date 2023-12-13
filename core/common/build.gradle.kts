plugins {
    id("taraftarplus.android.library")
    id("taraftarplus.android.library.compose")
}

android {
    namespace = "com.fourplay.common"
}

dependencies {
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.date)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.google.libphonenumber)
    implementation(libs.mapCompose)
    implementation(libs.maps)
}