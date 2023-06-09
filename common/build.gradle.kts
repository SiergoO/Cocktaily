import dependencies.Dependency

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
}

android {
    namespace = AndroidConfig.Project.NAMESPACE + ".common"
    compileSdk = AndroidConfig.SDK.COMPILE_VERSION

    defaultConfig {
        minSdk = AndroidConfig.SDK.MIN_VERSION

        testInstrumentationRunner = AndroidConfig.Test.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.Compose.COMPILER_VERSION
    }
}

dependencies {

    implementation(Dependency.KoIn.CORE)
    implementation(Dependency.KoIn.ANDROID)

    implementation(Dependency.Compose.UI)
    implementation(Dependency.Compose.FOUNDATION)
    implementation(Dependency.Compose.MATERIAL)
    implementation(Dependency.Compose.MATERIAL3)
    implementation(Dependency.Compose.MATERIAL_ICONS)
    implementation(Dependency.Compose.ACTIVITY)
    implementation(Dependency.Compose.PREVIEW)
    implementation(Dependency.Compose.TOOLING)

    implementation(Dependency.OrbitMVI.CORE)

    implementation(Dependency.Test.JUNIT_KTX)
    androidTestImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO_CORE)
}