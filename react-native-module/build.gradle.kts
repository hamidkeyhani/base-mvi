
plugins {
    id("mvi.android.library")
}

android {
    namespace = "com.example.react_native_module"
}
dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.com.google.android.material.material)
    implementation(libs.androidx.activity)
    implementation(libs.constraintlayout)
}