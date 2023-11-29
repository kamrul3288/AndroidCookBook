

import com.iamkamrul.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltWorkConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", libs.findLibrary("androidx.work.runtime").get())
                add("implementation", libs.findLibrary("androidx.hilt.work").get())
                add("implementation", libs.findLibrary("androidx.hilt.work").get())
                add("ksp", libs.findLibrary("androidx.hilt.compiler").get())
            }
        }
    }

}