plugins {
    id("mvi.android.library")
    id("mvi.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.base.network"
}

dependencies {
    implementation(project(":core:datastore"))
    implementation(project(":core:common"))
    debugImplementation(libs.chuckerInterceptor)
    releaseImplementation(libs.chuckerInterceptorNoOp)
    implementation(libs.retrofit)
    implementation(libs.okHttp)
    implementation(libs.okHttpLogging)
    implementation(libs.serializationJson)
    implementation(libs.retrofitSerializationConverter)
    implementation(libs.timber)

}