
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.seba.plantsorganizer.core.ui"
    compileSdk = 35

    defaultConfig {
        minSdk = 28
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    stabilityConfigurationFiles =
        listOf(rootProject.layout.projectDirectory.file("stability_config.conf"))
}

dependencies {
    implementation(project(":core"))

    // Compose UI
    implementation("androidx.compose.ui:ui:1.8.3")
    implementation("androidx.compose.material:material:1.8.3")
    implementation("androidx.compose.material3:material3:1.3.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.8.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.8.3")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.9.0")

    // ViewModel Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1")

    // Glide Compose (obrazki)
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

    // Ikony
    implementation("androidx.compose.material:material-icons-core:1.7.8")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    // Tests
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
}
