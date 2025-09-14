
object Versions {

  object App {
    private const val major = 1
    private const val minor = 0
    private const val patch = 0

    const val generatedCode = major * 10000 + minor * 100 + patch
    const val generatedName = "${major}.${minor}.${patch}"

    const val minSdk = 23
    const val compile = 36
    const val target = 36
  }

  object Androidx {
    const val core = "1.10.1"
    const val appcompat = "1.6.1"
    const val constraintlayout = "2.2.1"
    const val junit = "1.1.5"
    const val espresso = "3.5.1"
    const val lifecyleViewModel = "2.9.3"
    const val lifecyleExtensions = "2.2.0"
    const val composeCompilerExtension = "1.5.15"
    const val composeBom = "2024.09.01"
    const val composeActivity = "1.11.0"
    const val composeViewModel= "2.9.3"

  }

  object Google {
    const val material = "1.13.0"
  }

  const val kotlin = "2.2.0"
  const val hilt = "2.56.2"
  const val composeRoot = "2.0.0"
  const val nav = "2.9.4"
  const val glide = "4.13.0"
  const val retrofit = "2.9.0"
  const val okhttp = "4.10.0"
  const val gson = "2.10.1"
  const val chucker = "3.5.2"
  const val googleServices = "4.4.3"
  const val pluginApplication = "8.13.0"
  const val pluginLibrary = "8.13.0"
  const val junit = "4.13.2"
  const val sweetRecycler = "0.10.0"
  const val mockitoVersion = "5.4.0"
  const val coroutine = "1.10.2"
}
