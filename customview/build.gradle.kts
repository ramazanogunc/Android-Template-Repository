plugins {
  id(Plugins.library)
  id(Plugins.kotlin)
  id(Plugins.composeRoot)
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
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }
  kotlinOptions {
    jvmTarget = "21"
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.Androidx.composeCompilerExtension
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

  // COMPOSE
  val composeBom = platform(Deps.AndroidX.composeBom)
  implementation(composeBom)
  androidTestImplementation(composeBom)

  implementation(Deps.AndroidX.composeMaterial3)
  implementation(Deps.AndroidX.composeMaterial)
  implementation(Deps.AndroidX.composeFoundation)
  implementation(Deps.AndroidX.composeUi)

  implementation(Deps.sweetRecycler)

}