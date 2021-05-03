plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)
    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        versionCode = 1
        versionName = version as String
        testInstrumentationRunner = "io.qameta.allure.espresso.AllureAndroidRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    lintOptions {
        htmlReport = false
        isAbortOnError = false
        isWarningsAsErrors = false
        setLintConfig(file("allure-espresso-lint.xml"))
    }

    packagingOptions {
        exclude("LICENSE.txt")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }
}

dependencies {
    implementation(project(":allure-android-model"))
    implementation(project(":allure-android-commons"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.annotation:annotation:${Versions.Android.androidX}")
    implementation("androidx.test:runner:${Versions.Android.androidXTest}")
    implementation("androidx.test:rules:${Versions.Android.androidXTest}")
    implementation("androidx.multidex:multidex:${Versions.Android.multiDex}")
    implementation("androidx.test.uiautomator:uiautomator:${Versions.Android.uiAutomatorVersion}")
    implementation("junit:junit:${Versions.junit4}")

    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.espressoVersion}")
}

val copyLibs by tasks.creating(Copy::class.java) {
    into("libs") {
        from(configurations.compile)
        from(configurations.testCompile)
    }
}
