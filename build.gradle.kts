// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath ("com.google.gms:google-services:4.3.15")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false

}