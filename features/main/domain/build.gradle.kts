plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    api(project(":common"))

    //Coroutine
    implementation(libs.coroutines.core)

    //Paging
    implementation(libs.paging.common)

    //Koin
    implementation(libs.koin.core)
}