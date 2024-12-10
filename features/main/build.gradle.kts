plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigationArgs)
}

android {
    namespace = "com.x.main"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.bundles.lifecycle.component)

    //Koin
    implementation(libs.koin.android)

    //Paging
    implementation(libs.bundles.paging.component)

    //Navigation Component
    implementation(libs.bundles.navigation.component)

    //ViewBinding Delegate
    implementation(libs.binding)


    api(project(":features:main:data"))
    implementation(project(":core"))
}