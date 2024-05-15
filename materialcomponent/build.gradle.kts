plugins {
    alias(libs.plugins.iamkamrul.android.feature)
}
android {
    namespace = "com.iamkamrul.material"
}

dependencies {
    implementation(libs.androidx.viewpager2)
    implementation(libs.image.coil)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}