import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("mvi.android.library")
                apply("mvi.android.hilt")
            }
//            extensions.configure<LibraryExtension> {
//                defaultConfig {
//                    testInstrumentationRunner =
//                        "com.base.mvi.core.testing.NiaTestRunner"
//                }
//            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
               add("implementation", project(":core:common"))
               add("implementation", project(":core:datastore"))
               add("implementation", project(":core:designsystem"))
//               add("implementation", project(":core:network"))
//               add("implementation", project(":core:domain"))
//               add("implementation", project(":core:data"))
//               add("implementation", project(":core:sharedApi"))

//                add("testImplementation", kotlin("test"))
//                add("testImplementation", project(":core:testing"))
//                add("androidTestImplementation", kotlin("test"))
//                add("androidTestImplementation", project(":core:testing"))

                add("implementation", libs.findLibrary("coil.kt").get())
                add("implementation", libs.findLibrary("coil.kt.compose").get())

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
                add("implementation", libs.findLibrary("retrofit").get())
                add("implementation", libs.findLibrary("serializationJson").get())
                add("implementation", libs.findLibrary("timber").get())

            }
        }
    }
}
