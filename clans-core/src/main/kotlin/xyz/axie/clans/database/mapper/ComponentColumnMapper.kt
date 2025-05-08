package xyz.axie.clans.database.mapper

import net.kyori.adventure.text.Component
import org.jdbi.v3.core.mapper.ColumnMapper
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.database.util.ComponentSerializer.deserializeComponent
import java.sql.ResultSet

class ComponentColumnMapper : ColumnMapper<Component> {
    override fun map(rs: ResultSet, columnNumber: Int, ctx: StatementContext?): Component {
        return rs.getString(columnNumber).deserializeComponent()
    }
}