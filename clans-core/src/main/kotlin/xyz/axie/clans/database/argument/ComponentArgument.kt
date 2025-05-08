package xyz.axie.clans.database.argument

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.jdbi.v3.core.argument.AbstractArgumentFactory
import org.jdbi.v3.core.argument.Argument
import org.jdbi.v3.core.config.ConfigRegistry
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.database.util.ComponentSerializer.serialize
import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.Types

class ComponentArgument(
    private var component: Component?
) : Argument {

    @Throws(SQLException::class)
    override fun apply(position: Int, statement: PreparedStatement, ctx: StatementContext?) {

        if (component == null) {
            statement.setNull(position, Types.VARCHAR)
        } else {
            statement.setString(position, component!!.serialize())
        }

    }

}

class ComponentArgumentFactory : AbstractArgumentFactory<Component>(Types.VARBINARY) {

    override fun build(value: Component?, config: ConfigRegistry?): Argument = ComponentArgument(value)

}