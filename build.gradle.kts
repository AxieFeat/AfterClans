plugins {
    kotlin("jvm") version "2.1.10"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "xyz.axie.afterclans"
    version = "1.0"

    repositories {
        mavenCentral()

        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }

    dependencies {
        compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    }

    kotlin {
        jvmToolchain(8)
    }
}