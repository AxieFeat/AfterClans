package xyz.axie.clans.database.util

import java.nio.ByteBuffer
import java.util.UUID

object UUIDSerializer {

    @JvmStatic
    fun UUID.serialize(): ByteArray {
        val buffer = ByteBuffer.allocate(16)

        buffer.putLong(this.mostSignificantBits)
        buffer.putLong(this.leastSignificantBits)

        return buffer.array()
    }

    @JvmStatic
    fun ByteArray.deserializeUUID(): UUID {
        return ByteBuffer.wrap(this).let { UUID(it.long, it.long) }
    }

}