plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "AfterClans"

include("clans-api")
include("clans-core")
include("clans-economy")
include("clans-economy:clans-economy-core")
include("clans-economy:clans-economy-vault")
include("clans-economy:clans-economy-playerpoints")
include("clans-economy:clans-economy-stub")
