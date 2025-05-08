package xyz.axie.clans.database.mapper

import org.bukkit.inventory.ItemStack
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class ItemStackMapColumnMapper : ColumnMapper<Map<Int, ItemStack>> {

    override fun map(
        rs: ResultSet?, columnNumber: Int, ctx: StatementContext?
    ): Map<Int, ItemStack>? {
        TODO("Not yet implemented")
    }

}