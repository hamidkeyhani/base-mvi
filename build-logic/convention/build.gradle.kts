plugins {
    `kotlin-dsl`
}

group = "com.base.mvi.buildlogic"

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
            id = "mvi.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidFeatureData") {
            id = "mvi.android.feature.data"
            implementationClass = "AndroidFeatureDataConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "mvi.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "mvi.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "mvi.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "mvi.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "mvi.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        //        register("androidApplicationJacoco") {
//            id = "mvi.android.application.jacoco"
//            implementationClass = "AndroidApplicationJacocoConventionPlugin"
//        }
//        register("androidLibraryJacoco") {
//            id = "mvi.android.library.jacoco"
//            implementationClass = "AndroidLibraryJacocoConventionPlugin"
//        }
//        register("androidTest") {
//            id = "mvi.android.test"
//            implementationClass = "AndroidTestConventionPlugin"
//        }

//        register("firebase-perf") {
//            id = "mvi.firebase-perf"
//            implementationClass = "FirebasePerfConventionPlugin"
//        }
    }
}
