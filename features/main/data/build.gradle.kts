plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.x.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24


        buildConfigField("String", "BASE_URL", "\"https://drive.usercontent.google.com/u/0/\"")
        buildConfigField("String", "TICKETS_BASE_URL", "\"https://drive.google.com/\"")
        buildConfigField("String", "TICKETS_API_KEY", "\"1HogOsz4hWkRwco4kud3isZHFQLUAwNBA\"")
        buildConfigField("String", "TICKETS_OFFERS_API_KEY", "\"13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta\"")
        buildConfigField("String", "OFFERS_API_KEY", "\"1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav\"")

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
        buildConfig = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.gson.converter)

    //OkHttp
    implementation(libs.bundles.okhttp.component)
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //Paging
    implementation(libs.bundles.paging.component)

    //Coroutine
    implementation(libs.coroutines.core)

    //Koin
    implementation(libs.koin.android)

    api(project(":features:main:domain"))
}