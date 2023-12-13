plugins {
    id("taraftarplus.android.library")
    id("taraftarplus.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.fourplay.network"
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