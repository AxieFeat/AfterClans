repositories {
    maven("https://repo.rosewooddev.io/repository/public/")
}

dependencies {
    api(project(":clans-economy:clans-economy-core"))

    compileOnly("org.black_ixx:playerpoints:3.3.2")
}