package xyz.axie.clans.database.argument

import org.jdbi.v3.core.argument.AbstractArgumentFactory
import org.jdbi.v3.core.argument.Argument
import org.jdbi.v3.core.config.ConfigRegistry
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.player.PlayerSettings
import java.sql.PreparedStatement
import java.sql.Types

class PlayerSettingsArgument(
    private val settings: PlayerSettings?
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

class PlayerSettingsArgumentFactory : AbstractArgumentFactory<PlayerSettings>(Types.VARCHAR) {

    override fun build(value: PlayerSettings?, config: ConfigRegistry?): Argument = PlayerSettingsArgument(value)
}