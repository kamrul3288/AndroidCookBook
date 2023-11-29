

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "co.iamkamrul.buildlogic"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "iamkamrul.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "iamkamrul.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "iamkamrul.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidFeature") {
            id = "iamkamrul.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidRoom") {
            id = "iamkamrul.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("androidRetrofit") {
            id = "iamkamrul.android.retrofit"
            implementationClass = "AndroidRetrofitConventionPlugin"
        }

        register("androidNavigationComponent") {
            id = "iamkamrul.android.navigation"
            implementationClass = "AndroidNavigationComponentConventionPlugin"
        }

        register("androidHiltWork") {
            id = "iamkamrul.android.hilt.work"
            implementationClass = "AndroidHiltWorkConventionPlugin"
        }

        register("androidFirebase") {
            id = "iamkamrul.android.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }

        register("jvmLibrary") {
            id = "iamkamrul.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
