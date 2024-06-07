# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-renamesourcefileattribute SourceFile
#-------------------------MODEL RULES--------------------------------
-keep class com.jatri.entity.** { *; }
-keep class com.jatri.apiresponse.** { *; }
-keep class com.jatri.navigation.** { *; }
-keep class com.jatri.di.authrefresh.** { *; }

#-------------------RETROFIT-----------------------------------
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

 #--------------GSON----------------
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
-keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
-keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken

-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**

 #--------------Place----------------
-dontwarn io.grpc.internal.DnsNameResolverProvider
-dontwarn io.grpc.internal.PickFirstLoadBalancerProvider
-dontwarn io.grpc.LoadBalancerProvider
-dontwarn io.grpc.NameResolverProvider

 #--------------SIGNALR----------------
-keep class com.microsoft.signalr.** { *; }
-assumenosideeffects class com.microsoft.signalr.** { *; }
-dontwarn com.microsoft.signalr.**
-dontwarn org.slf4j.impl.StaticLoggerBinder

# Optional rules
-keep,allowobfuscation class com.microsoft.signalr.** { *; }
-keepnames class com.microsoft.signalr.** { *; }
-keepclassmembers class com.microsoft.signalr.** { *; }