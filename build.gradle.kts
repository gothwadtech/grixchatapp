// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.compose) apply false
  alias(libs.plugins.google.devtools.ksp) apply false
  alias(libs.plugins.roborazzi) apply false
  alias(libs.plugins.secrets) apply false
}

tasks.register<Copy>("copyApk") {
    dependsOn(":app:assembleDebug")
    from(file("app/build/outputs/apk/debug/app-debug.apk"))
    into(projectDir)
    rename { "grixchat.apk" }
}

tasks.register<Copy>("copyApkWithOriginalName") {
    dependsOn("copyApk")
    from(file("app/build/outputs/apk/debug/app-debug.apk"))
    into(file("output"))
}







