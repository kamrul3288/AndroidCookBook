plugins {
   id("iamkamrul.android.library")
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