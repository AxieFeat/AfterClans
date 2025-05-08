package xyz.axie.clans.database.argument

import org.bukkit.inventory.ItemStack
import org.jdbi.v3.core.argument.AbstractArgumentFactory
import org.jdbi.v3.core.argument.Argument
import org.jdbi.v3.core.config.ConfigRegistry
import org.jdbi.v3.core.statement.StatementContext
import java.sql.PreparedStatement
import java.sql.Types

class ItemStackArgument(
    private val item: ItemStack?
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

class ItemStackArgumentFactory : AbstractArgumentFactory<ItemStack>(Types.VARCHAR) {

    override fun build(value: ItemStack?, config: ConfigRegistry?): Argument = ItemStackArgument(value)
}