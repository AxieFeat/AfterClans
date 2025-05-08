package xyz.axie.clans.player

/**
 * This interface represents some player permission in clan.
 *
 * @param T Type of permission object.
 */
interface Permission<T> {

    /**
     * Permission id.
     */
    val id: String

    /**
     * Default value of this permission.
     */
    val default: T

    /**
     * Try parse value of this permission from any object.
     *
     * @return Parsed instance of [T] or [default], if object can not be parsed.
     */
    fun parse(any: Any): T

}