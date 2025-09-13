// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
    }
    dependencies {
        classpath(Deps.AndroidX.navigationPlugin)
        classpath(Deps.Google.googleRootPlugin)
    }
}

plugins {
    id(Plugins.application) version Versions.pluginApplication apply false
    id(Plugins.library) version Versions.pluginLibrary apply false
    id(Plugins.kotlin) version Versions.kotlin apply false
    id(Plugins.hiltRoot) version Versions.hilt apply false
    id(Plugins.composeRoot) version Versions.composeRoot apply false
}