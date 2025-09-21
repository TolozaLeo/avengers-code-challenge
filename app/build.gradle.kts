plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.daggerHiltAndroid)
    id("kotlin-parcelize")
}
// Acceder al local.properties para leer las API keys
val localProperties = org.jetbrains.kotlin.konan.properties.Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}

hilt {
    enableAggregatingTask = false
}

android {
    namespace = "dev.leotoloza.avengersapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "dev.leotoloza.avengersapp"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Exponer las API keys como constantes BuildConfig para acceder desde código
        val publicApiKey = localProperties.getProperty("API_PUBLIC_KEY", "")
        buildConfigField("String", "API_PUBLIC_KEY", "\"$publicApiKey\"")
        manifestPlaceholders["API_PUBLIC_KEY"] = publicApiKey

        val privateApikey = localProperties.getProperty("API_PRIVATE_KEY", "")
        buildConfigField("String", "API_PRIVATE_KEY", "\"$privateApikey\"")
        manifestPlaceholders["API_PRIVATE_KEY"] = publicApiKey
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
//    Standard libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    Viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.compose)
//    Navigation
    implementation(libs.androidx.navigation.compose)
//    Coil para carga de imagenes
    implementation(libs.coil.compose)
//    Dagger Hilt + ksp para inyeccion de dependencias
    implementation(libs.google.dagger.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.google.dagger.hilt.android.compiler)
}