import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.kotlin.dsl.withType

dependencies {
    implementation(project(":clans-api"))

    implementation(project(":clans-economy:clans-economy-vault"))
    implementation(project(":clans-economy:clans-economy-playerpoints"))
    implementation(project(":clans-economy:clans-economy-stub"))

    compileOnly("io.insert-koin:koin-core-jvm:4.0.4")

    compileOnly("net.kyori:adventure-text-serializer-plain:4.20.0")
    compileOnly("net.kyori:adventure-text-minimessage:4.21.0")

    compileOnly("com.zaxxer:HikariCP:6.3.0")
    compileOnly("org.jdbi:jdbi3-core:3.49.2")
    compileOnly("org.jdbi:jdbi3-caffeine-cache:3.49.2")
    compileOnly("org.jdbi:jdbi3-kotlin-sqlobject:3.49.2")
    compileOnly("com.github.ben-manes.caffeine:caffeine:3.2.0")
}

tasks.withType<ShadowJar> {
    archiveFileName.set("AfterClans.jar")

    destinationDirectory = file("././server/plugins")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}