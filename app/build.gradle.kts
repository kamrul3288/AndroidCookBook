plugins {
    id("iamkamrul.android.application")
    id("iamkamrul.android.hilt")
    id("iamkamrul.android.navigation")
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
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))

    implementation(project(":navigation-component:login"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.corektx)
    implementation(libs.androidx.material)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}