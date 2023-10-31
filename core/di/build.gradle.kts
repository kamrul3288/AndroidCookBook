plugins {
    id("iamkamrul.android.library")
    id("iamkamrul.android.hilt")
    id("iamkamrul.android.retrofit")
}

android {
    namespace = "com.iamkamrul.di"
}

dependencies {
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}