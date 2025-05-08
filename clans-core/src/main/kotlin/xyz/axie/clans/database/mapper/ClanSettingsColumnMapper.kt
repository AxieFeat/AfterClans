package xyz.axie.clans.database.mapper

import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.clan.ClanSettings
import java.sql.ResultSet

class ClanSettingsColumnMapper : ColumnMapper<ClanSettings> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): ClanSettings {
        TODO()
    }
}