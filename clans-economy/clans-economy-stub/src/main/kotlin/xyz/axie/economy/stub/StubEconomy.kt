package xyz.axie.economy.stub

import xyz.axie.economy.Economy
import java.util.UUID

class StubEconomy<T : Number> : Economy<T> {

    override val name: String = "stub"

    override fun hook() {}

    @Suppress("UNCHECKED_CAST")
    override fun get(uuid: UUID): T = 0 as T
    override fun set(uuid: UUID, amount: T) {}
    override fun add(uuid: UUID, amount: T): Boolean = false
    override fun take(uuid: UUID, amount: T): Boolean = false

}