plugins {
    `kotlin-dsl`
}

group = "com.fourplay.taraftarplus.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidFeature") {
            id = "taraftarplus.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidFeatureData") {
            id = "taraftarplus.android.feature.data"
            implementationClass = "AndroidFeatureDataConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "taraftarplus.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "taraftarplus.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "taraftarplus.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "taraftarplus.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "taraftarplus.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        //        register("androidApplicationJacoco") {
//            id = "nowinandroid.android.application.jacoco"
//            implementationClass = "AndroidApplicationJacocoConventionPlugin"
//        }
//        register("androidLibraryJacoco") {
//            id = "nowinandroid.android.library.jacoco"
//            implementationClass = "AndroidLibraryJacocoConventionPlugin"
//        }
//        register("androidTest") {
//            id = "nowinandroid.android.test"
//            implementationClass = "AndroidTestConventionPlugin"
//        }

//        register("firebase-perf") {
//            id = "nowinandroid.firebase-perf"
//            implementationClass = "FirebasePerfConventionPlugin"
//        }
    }
}
