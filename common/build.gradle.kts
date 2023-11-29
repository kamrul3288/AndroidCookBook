@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
   alias(libs.plugins.iamkamrul.android.library)
}

android {
    namespace = "com.iamkamrul.common"
}

dependencies {
    implementation(libs.androidx.corektx)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}