plugins {
    kotlin("multiplatform") version "1.9.20"
    id("com.android.library")
}

group = "com.kal"
version = "1.0-SNAPSHOT"

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

kotlin {
    androidTarget {
        publishAllLibraryVariants()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "TryKmpWasm"
        }
    }

    @Suppress("OPT_IN_USAGE")
    wasmJs {
        browser()
        binaries.library()
        // generateTypeScriptDefinitions() the js target has this, wish wasmJs had it too
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
        }
        val wasmJsMain by getting
        val wasmJsTest by getting
    }
}

android {
    compileSdk = 34
    defaultConfig {
        minSdk = 27
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    namespace = "com.kal.tryKmpWasm"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}
