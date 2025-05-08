package xyz.axie.clans.database.mapper

import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.util.*

class UUIDSetColumnMapper : ColumnMapper<Set<UUID>> {

    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): Set<UUID> {
        val hexString = rs.getString(columnNumber)
        return hexString?.split(",")?.dropLastWhile { it.isEmpty() }
            ?.mapNotNull { UUID.fromString(it) }
            ?.toSet() ?: emptySet()
    }

}
