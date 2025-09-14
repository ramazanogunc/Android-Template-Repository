plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
    id(Plugins.kapt)
    id(Plugins.hilt)
    id(Plugins.safearg)
    id(Plugins.composeRoot)
}

android {
    namespace = "com.ramo.example"
    compileSdk = Versions.App.compile

    defaultConfig {
        applicationId = "com.ramo.example"
        minSdk = Versions.App.minSdk
        targetSdk = Versions.App.target
        versionCode = Versions.App.generatedCode
        versionName = Versions.App.generatedName
        testInstrumentationRunner = Deps.AndroidX.androidJUnitRunner
    }

    flavorDimensions += "version"
    productFlavors {
        create("dev")  {
            dimension = "version"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            resValue("string", "app_name", "@string/app_name_dev")
        }
        create("prod")  {
            dimension = "version"
            resValue("string", "app_name", "@string/app_name_production")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Androidx.composeCompilerExtension
    }

//    applicationVariants.all { variant ->
//        val appName = "ramo_app"
//        variant.outputs.all {
//            outputFileName = "${appName}_${variant.productFlavors[0].name}_${variant.buildType.name}_${defaultConfig.versionName}.apk"
//        }
//    }
}

dependencies {
    // ANDROIDX
    implementation(Deps.AndroidX.core)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.constraintlayout)

    androidTestImplementation(Deps.AndroidX.junit)
    androidTestImplementation(Deps.AndroidX.espresso)

    // LIFECYCLE
    implementation(Deps.AndroidX.lifecyleViewModel)
    implementation(Deps.AndroidX.lifecyleExtensions)

    // COMPOSE
    val composeBom = platform(Deps.AndroidX.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(Deps.AndroidX.composeMaterial3)
    implementation(Deps.AndroidX.composeMaterial)
    implementation(Deps.AndroidX.composeFoundation)
    implementation(Deps.AndroidX.composeUi)

    // Android Studio Preview support
    implementation(Deps.AndroidX.composeUiToolingPreview)
    implementation(Deps.AndroidX.composeUiTooling)

    // Optional - Integration with activities
    implementation(Deps.AndroidX.composeActivity)
    // Optional - Integration with ViewModels
    implementation(Deps.AndroidX.composeViewModel)

    // NAVIGATION COMPONENT
    implementation(Deps.AndroidX.navigationFragment)
    implementation(Deps.AndroidX.navigationUi)

    implementation(Deps.Google.material)
    testImplementation(Deps.junit)


    // DI DAGGER HILT
    implementation(Deps.Google.hilt)
    kapt(Deps.Google.hiltCompiler)


    // GLIDE
    implementation(Deps.glide)
    kapt(Deps.glideCompiler)


    // MY LIBS
//    implementation("com.github.ramazanogunc:Android-Sweet-Sdk:0.9.7"
    implementation(Deps.sweetRecycler)

    // DATA AND CUSTOM VIEW MODULES
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data"))) // todo this for dagger hilt problem
    implementation(project(mapOf("path" to ":customview")))

}