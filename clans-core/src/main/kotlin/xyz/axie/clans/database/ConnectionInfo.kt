package xyz.axie.clans.database

/**
 * Just info about connection to database.
 *
 * Note: If you use [DatabaseType.SQLITE] all parameters are not used (exclude [type]).
 */
data class ConnectionInfo(
    val type: DatabaseType,
    val host: String,
    val port: Int,
    val database: String,
    val user: String,
    val password: String
)