plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":allure-android-model"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("com.google.code.gson:gson:${Versions.gson}")
    implementation("junit:junit:${Versions.junit4}")

    testImplementation("org.hamcrest:hamcrest-all:${Versions.hamcrestVersion}")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}")
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
    getByName("test").java.srcDirs("src/test/kotlin")
}

val copyLibs by tasks.creating(Copy::class.java) {
    into("libs") {
        from(configurations.compile)
        from(configurations.testCompile)
    }
}
