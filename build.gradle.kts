plugins {
    kotlin("jvm") version "2.1.10"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java-library")
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")

    group = "xyz.axie.afterclans"
    version = "1.0"

    repositories {
        mavenLocal()
        mavenCentral()

        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }

    dependencies {
        compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.1.10")
        compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    }

    kotlin {
        jvmToolchain(11)
    }
}