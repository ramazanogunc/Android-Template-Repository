/**
 * Created by ramazanogunc
 * Created at 16.08.2023
 */
object Deps {

  object AndroidX {
    private const val pre = "androidx."
    const val navigationPlugin = pre + "navigation:navigation-safe-args-gradle-plugin:${Versions.nav}"
    const val androidJUnitRunner = pre + "test.runner.AndroidJUnitRunner"
    const val core = pre + "core:core-ktx:${Versions.Androidx.core}"
    const val appcompat = pre + "appcompat:appcompat:${Versions.Androidx.appcompat}"
    const val constraintlayout = pre + "constraintlayout:constraintlayout:${Versions.Androidx.constraintlayout}"
    const val junit = pre + "test.ext:junit:${Versions.Androidx.junit}"
    const val espresso = pre + "test.espresso:espresso-core:${Versions.Androidx.espresso}"
    const val lifecyleViewModel = pre + "lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.lifecyleViewModel}"
    const val lifecyleExtensions = pre + "lifecycle:lifecycle-extensions:${Versions.Androidx.lifecyleExtensions}"
    const val composeBom = pre + "compose:compose-bom:${Versions.Androidx.composeBom}"
    const val composeMaterial3 = pre + "compose.material3:material3"
    const val composeMaterial = pre + "compose.material:material"
    const val composeFoundation = pre + "compose.foundation:foundation"
    const val composeUi = pre + "compose.ui:ui"
    const val composeUiToolingPreview = pre + "compose.ui:ui-tooling-preview"
    const val composeUiTooling = pre + "compose.ui:ui-tooling"
    const val composeActivity = pre + "activity:activity-compose:${Versions.Androidx.composeActivity}"
    const val composeViewModel = pre + "lifecycle:lifecycle-viewmodel-compose:${Versions.Androidx.composeViewModel}"
    const val navigationFragment = pre + "navigation:navigation-fragment-ktx:${Versions.nav}"
    const val navigationUi = pre + "navigation:navigation-ui-ktx:${Versions.nav}"
  }

  object Google {
    private const val pre = "com.google."
    const val  googleRootPlugin = pre + "gms:google-services:${Versions.googleServices}"
    const val  material = pre + "android.material:material:${Versions.Google.material}"
    const val  hilt = pre + "dagger:hilt-android:${Versions.hilt}"
    const val  hiltCompiler = pre + "dagger:hilt-compiler:${Versions.hilt}"
  }

  object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor"
    const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

  }

  const val junit = "junit:junit:${Versions.junit}"
  const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
  const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
  const val sweetRecycler = "com.github.ramazanogunc:Sweet-Recycler-View:${Versions.sweetRecycler}"
  const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoVersion}"
  const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockitoVersion}"
  const val testCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"

}