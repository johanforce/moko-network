buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.6.21")
        classpath("com.android.tools.build:gradle:7.2.0")
        classpath("dev.icerock.moko:kswift-gradle-plugin:0.5.0")
        classpath("dev.icerock.moko:network-generator:0.17.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}