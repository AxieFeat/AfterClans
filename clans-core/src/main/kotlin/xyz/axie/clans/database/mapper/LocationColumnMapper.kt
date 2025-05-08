package xyz.axie.clans.database.mapper

import org.bukkit.Location
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class LocationColumnMapper : ColumnMapper<Location?> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): Location? {
        TODO()
    }
}
