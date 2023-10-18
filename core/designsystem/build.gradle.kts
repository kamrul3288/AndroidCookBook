plugins {
    id("iamkamrul.android.library")
}

android {
    namespace = "com.iamkamrul.designsystem"
}

dependencies {
    implementation(libs.androidx.corektx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
    implementation(libs.dimension.sdp)
    implementation(libs.dimension.ssp)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}