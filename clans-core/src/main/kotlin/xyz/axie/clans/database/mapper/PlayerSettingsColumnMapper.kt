package xyz.axie.clans.database.mapper

import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.player.PlayerSettings
import java.sql.ResultSet

class PlayerSettingsColumnMapper : ColumnMapper<PlayerSettings> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): PlayerSettings {
        TODO()
    }
}