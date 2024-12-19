plugins {
    id("mvi.android.library")
    id("mvi.android.library.compose")
}

android {
    namespace = "com.base.designsystem"
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.material3)
    debugApi(libs.androidx.compose.ui.tooling)
    debugApi(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.flag.kit)
    implementation(libs.date)
    implementation(libs.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.coil)
    implementation(libs.coil.kt.svg)
    implementation(libs.mapCompose)
    implementation(libs.maps)
    implementation(libs.playLocation)
    implementation(libs.androidx.appcompat)
}