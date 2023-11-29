@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.iamkamrul.android.library)
}

android {
    namespace = "com.iamkamrul.designsystem"
}

dependencies {
    api(libs.androidx.corektx)
    api(libs.androidx.appcompat)
    api(libs.androidx.material)
    api(libs.dimension.sdp)
    api(libs.dimension.ssp)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}