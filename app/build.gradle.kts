@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.iamkamrul.android.application)
    alias(libs.plugins.iamkamrul.android.hilt)
    alias(libs.plugins.iamkamrul.android.navigation)
}

android {
    namespace = "com.iamkamrul.cookbook"
    defaultConfig {
        applicationId = "com.iamkamrul.cookbook"
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug{
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.di)

    implementation(projects.navigationcomponent.login)
    implementation(projects.navigationcomponent.otpverify)
    implementation(projects.navigationcomponent.signup)

    implementation(projects.features.phonebook)
    implementation(projects.materialcomponent)
    implementation(projects.thirdPartyLibrary)

    implementation(libs.log.timber)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}