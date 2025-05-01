package xyz.axie.economy

import java.util.UUID
import kotlin.jvm.Throws

/**
 * This interface represents some economy system instance.
 *
 * @param T Type of currency.
 */
interface Economy<T : Number> {

    /**
     * Name of implementation, useful for debugging.
     */
    val name: String

    /**
     * Try hook this economy system.
     *
     * @throws UnsupportedOperationException If this economy not provided.
     */
    @Throws(UnsupportedOperationException::class)
    fun hook()

    /**
     * Get balance of some player.
     *
     * @param UUID UUID of player.
     *
     * @return Balance of player.
     */
    fun get(uuid: UUID): T

    /**
     * Set balance for some player.
     *
     * @param uuid UUID of player.
     * @param amount Amount of money.
     */
    fun set(uuid: UUID, amount: T)

    /**
     * Add some money to balance for some player.
     *
     * @param uuid UUID of player.
     * @param amount Amount of money.
     *
     * @return `true` if success, otherwise `false`.
     */
    fun add(uuid: UUID, amount: T): Boolean

    /**
     * Take some money from balance of some player.
     *
     * @param uuid UUID of player.
     * @param amount Amount of money.
     *
     * @return `true` if success, otherwise `false`.
     */
    fun take(uuid: UUID, amount: T): Boolean

}