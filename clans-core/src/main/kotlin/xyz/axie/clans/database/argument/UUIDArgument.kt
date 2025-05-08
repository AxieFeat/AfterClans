package xyz.axie.clans.database.argument

import org.jdbi.v3.core.argument.AbstractArgumentFactory
import org.jdbi.v3.core.argument.Argument
import org.jdbi.v3.core.config.ConfigRegistry
import org.jdbi.v3.core.statement.StatementContext
import xyz.axie.clans.database.util.UUIDSerializer.serialize
import java.sql.PreparedStatement
import java.sql.Types
import java.util.UUID

class UUIDArgument(
    private val uuid: UUID?
) : Argument {

    override fun apply(position: Int, statement: PreparedStatement, ctx: StatementContext?) {
        if (uuid == null) {
            statement.setNull(position, Types.BINARY)
        } else {
            statement.setBytes(position, uuid.serialize())
        }
    }
}

class UUIDArgumentFactory : AbstractArgumentFactory<UUID>(Types.BINARY) {

    override fun build(value: UUID?, config: ConfigRegistry?): Argument = UUIDArgument(value)
}
