plugins {
  id(Plugins.library)
  id(Plugins.kotlin)
}

android {
  namespace = "com.ramo.example.customview"
  compileSdk = 33

  defaultConfig {
    minSdk = Versions.App.minSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
  buildFeatures {
    viewBinding = true
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  // ANDROIDX
  implementation(Deps.AndroidX.core)
  implementation(Deps.AndroidX.appcompat)
  implementation(Deps.AndroidX.constraintlayout)
  androidTestImplementation(Deps.AndroidX.junit)
  androidTestImplementation(Deps.AndroidX.espresso)

  // GOOGLE
  implementation(Deps.Google.material)
  testImplementation(Deps.junit)

  implementation(Deps.sweetRecycler)

}