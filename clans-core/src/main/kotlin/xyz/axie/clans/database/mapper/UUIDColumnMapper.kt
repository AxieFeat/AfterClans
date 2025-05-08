package xyz.axie.clans.database.mapper

import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.database.util.UUIDSerializer.deserializeUUID
import java.sql.ResultSet
import java.util.*

class UUIDColumnMapper : ColumnMapper<UUID> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): UUID {
        return rs.getBytes(columnNumber).deserializeUUID()
    }
}
