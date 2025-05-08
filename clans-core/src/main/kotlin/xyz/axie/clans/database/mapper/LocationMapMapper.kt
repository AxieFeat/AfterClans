package xyz.axie.clans.database.mapper

import org.bukkit.Location
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class LocationMapMapper : ColumnMapper<Map<String, Location>> {
    override fun map(rs: ResultSet?, columnNumber: Int, ctx: StatementContext?): Map<String, Location>? {
        val homesString = rs?.getString(columnNumber)
        return homesString?.split(",")
            ?.associate {
                val parts = it.split(":")
                val homeName = parts[0]
                val location = TODO()
                homeName to location
            } ?: emptyMap()
    }
}