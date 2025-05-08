package xyz.axie.clans.database.argument

import org.bukkit.Location
import org.jdbi.v3.core.argument.AbstractArgumentFactory
import org.jdbi.v3.core.argument.Argument
import org.jdbi.v3.core.config.ConfigRegistry
import org.jdbi.v3.core.statement.StatementContext
import java.sql.PreparedStatement
import java.sql.Types


class LocationArgument(
    private val item: Location?
) : Argument {

    override fun apply(position: Int, statement: PreparedStatement, ctx: StatementContext?) {
        if (item == null) {
            statement.setNull(position, Types.VARCHAR)
        } else {
            // TODO
//            statement.setString(position)
        }
    }
}

class LocationArgumentFactory : AbstractArgumentFactory<Location>(Types.VARCHAR) {

    override fun build(value: Location?, config: ConfigRegistry?): Argument = LocationArgument(value)
}