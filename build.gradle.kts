plugins {
    signing
    `maven-publish`

    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"

    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.serialization") version Versions.kotlin
}


buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }

    dependencies {
        classpath("com.github.dcendents:android-maven-gradle-plugin:${Versions.Android.mavenPlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Versions.Android.gradlePlugin}")
    }
}

val gradleScriptDir by extra("${rootProject.projectDir}/gradle")

allprojects {
    group = "io.qameta.allure"
    version = version

    repositories {
        mavenCentral()
        maven(url = "https://kotlin.bintray.com/kotlinx")
        google()
        jcenter()
    }
}
