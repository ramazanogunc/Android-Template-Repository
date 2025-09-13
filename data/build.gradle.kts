plugins {
  id(Plugins.library)
  id(Plugins.kotlin)
  id(Plugins.kapt)
  id(Plugins.hilt)
}

android {
  namespace = "com.ramo.example.data"
  compileSdk = Versions.App.compile

  defaultConfig {
    minSdk = Versions.App.minSdk

    testInstrumentationRunner = Deps.AndroidX.androidJUnitRunner
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }
  kotlinOptions {
    jvmTarget = "21"
  }
}

dependencies {
  // ANDROIDX
  implementation(Deps.AndroidX.core)
  implementation(Deps.AndroidX.appcompat)
  androidTestImplementation(Deps.AndroidX.junit)
  androidTestImplementation(Deps.AndroidX.espresso)

  // GOOGLE
  implementation(Deps.Google.material)
  testImplementation(Deps.junit)

  // DI DAGGER HILT
  implementation(Deps.Google.hilt)
  kapt(Deps.Google.hiltCompiler)

  // NETWORK
  implementation(Deps.Network.retrofit)
  implementation(Deps.Network.retrofitGsonConverter)
  implementation(platform(Deps.Network.okhttpBom))
  implementation(Deps.Network.okhttp)
  implementation(Deps.Network.okhttpLogging)

  // NETWORK LOGGING
  debugImplementation(Deps.Network.chuckerDebug)
  releaseImplementation(Deps.Network.chuckerRelease)

  // JSON
  implementation(Deps.Network.gson)

  implementation(project(mapOf("path" to ":domain")))
}