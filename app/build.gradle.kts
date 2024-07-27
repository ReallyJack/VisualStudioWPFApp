import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude

plugins {
    id("com.google.gms.google-services")
    alias(libs.plugins.android.application)
}

android {
    signingConfigs {
        create("config") {
            storeFile =
                file("D:\\UPSKILLED\\CERTIV\\ICTPRG436\\AppDeploymentPackage\\upload-keystore.jks")
            storePassword = "admin123"
            keyAlias = "key_alias"
            keyPassword = "admin123"
        }
    }
    namespace = "com.example.ttf"
    compileSdk = 34

    buildTypes {
        release {
            isDebuggable = false
            signingConfig = signingConfigs.getByName("config")
        }
        debug {
            isDebuggable = true
        }
    }

    defaultConfig {
        applicationId = "com.example.ttf"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(libs.google.firebase.database)
    implementation(libs.ext.junit)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)

    implementation(platform(libs.firebase.bom))
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.junit)
}