plugins {
   id("iamkamrul.android.feature")
}

android {
    namespace = "com.iamkamrul.navigation.otpverify"

}

dependencies {
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}