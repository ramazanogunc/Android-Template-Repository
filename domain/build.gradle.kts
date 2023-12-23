plugins {
  id(Plugins.library)
  id(Plugins.kotlin)
  id(Plugins.kapt)
  id(Plugins.hilt)
}

android {
  namespace = "com.ramo.example.domain"
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
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
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

  implementation(Deps.sweetRecycler)

  // DI DAGGER HILT
  implementation(Deps.Google.hilt)
  kapt(Deps.Google.hiltCompiler)

  // Mokito
  testImplementation(Deps.mockitoCore)
  androidTestImplementation(Deps.mockitoAndroid)
  testImplementation(Deps.testCoroutine)


}