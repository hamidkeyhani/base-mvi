pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

rootProject.name = "mvi"
include(":app")
include(":core")
include(":core:designsystem")
include(":core:common")
include(":core:datastore")
include(":feature")
include(":feature:onBoarding")
include(":core:network")
include(":react-native-module")
