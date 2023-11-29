@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.iamkamrul.android.library)
}

android {
    namespace = "com.iamkamrul.ui"
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:designsystem"))

    api(libs.androidx.corektx)
    api(libs.androidx.appcompat)
    api(libs.androidx.material)
    api(libs.androidx.activity)
    api(libs.androidx.fragment)
    api(libs.androidx.cardview)
    api(libs.androidx.navigation.ui)
    api(libs.androidx.navigation.ktx)
    api(libs.androidx.constraintlayout)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.kotlinx.coroutines.android)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}