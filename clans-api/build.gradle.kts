dependencies {
    api("xyz.axie.nbt:Kotlin-NBT:1.1")

    // Overrides dependencies from Kotlin-NBT library.
    compileOnly("org.jetbrains:annotations:26.0.1")
    compileOnly("org.pcollections:pcollections:4.0.0")
}