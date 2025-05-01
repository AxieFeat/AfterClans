package xyz.axie.clans.menu

import net.kyori.adventure.text.Component
import org.jetbrains.annotations.Range

/**
 * This interface represents factory of menus.
 */
interface MenuFactory {

    /**
     * Create new menu with name and size.
     *
     * @param name Name of menu.
     * @param size Size of menu.
     *
     * @return New instance of [Menu].
     *
     * @throws IllegalArgumentException If [size] is not a multiple of 9 or is greater than 54 or negative.
     */
    @Throws(IllegalArgumentException::class)
    fun create(
        name: Component = Component.text(""),
        size: @Range(from = 9, to = 54) Int = MenuSize.ROWS_6.slots,
    ): Menu

    /**
     * Clear all caches.
     */
    fun clear()

}