pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://www.jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")

    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://www.jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")
    }
}


rootProject.name = "AndroidCookBook"
include(":app")
include(":core:designsystem")
include(":common")
include(":core:ui")
include(":navigationcomponent:login")
include(":navigationcomponent:otpverify")
include(":navigationcomponent:signup")
include(":core:model:entity")
include(":core:di")
include(":features:phonebook")
include(":materialcomponent")
