plugins {
    id("iamkamrul.android.library")
}

android {
    namespace = "com.iamkamrul.ui"
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:designsystem"))

    implementation(libs.androidx.corektx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.ktx)
    implementation(libs.androidx.constraintlayout)


    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.kotlinx.coroutines.android)



    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}