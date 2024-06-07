plugins {
    alias(libs.plugins.iamkamrul.android.feature)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}
android {
    namespace = "com.iamkamrul.tpl"
}

dependencies {
    implementation(libs.microsoft.signalR)
    implementation(libs.microsoft.signalRLogger)
    implementation(libs.gson)


    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.extjunit)
    androidTestImplementation(libs.test.espresso)
}