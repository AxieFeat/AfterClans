package xyz.axie.clans.database.argument

import org.jdbi.v3.core.argument.AbstractArgumentFactory
import org.jdbi.v3.core.argument.Argument
import org.jdbi.v3.core.config.ConfigRegistry
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.clan.ClanSettings
import java.sql.PreparedStatement
import java.sql.Types

class ClanSettingsArgument(
    private val settings: ClanSettings?
) : Argument {

    override fun apply(position: Int, statement: PreparedStatement, ctx: StatementContext?) {
        if (settings == null) {
            statement.setNull(position, Types.VARCHAR)
        } else {
            // TODO
//            statement.setString(position)
        }
    }
}

class ClanSettingsArgumentFactory : AbstractArgumentFactory<ClanSettings>(Types.VARCHAR) {

    override fun build(value: ClanSettings?, config: ConfigRegistry?): Argument = ClanSettingsArgument(value)
}