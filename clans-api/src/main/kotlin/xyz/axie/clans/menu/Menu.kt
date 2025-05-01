package xyz.axie.clans.menu

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.InventoryHolder
import org.bukkit.persistence.PersistentDataHolder
import org.jetbrains.annotations.Range
import java.util.function.Consumer

/**
 * This interface represents some menu.
 */
interface Menu : InventoryHolder, PersistentDataHolder, Iterable<Map.Entry<Int, MenuItem>> {

    /**
     * Title of menu.
     */
    var title: Component

    /**
     * Count of slots in this menu.
     *
     * @throws IllegalArgumentException If the number is not a multiple of 9 or is greater than 54 or negative.
     */
    @set:Throws(IllegalArgumentException::class)
    var size: @Range(from = 9, to = 54) Int

    /**
     * All items in this menu.
     */
    val items: Map<Int, MenuItem>

    /**
     * Consumer for click event on this menu.
     *
     * @param consumer Consumer for click event.
     */
    fun onClick(consumer: Consumer<InventoryClickEvent>)

    /**
     * Consumer for drag event on this menu.
     *
     * @param consumer Consumer for drag event.
     */
    fun onDrag(consumer: Consumer<InventoryDragEvent>)

    /**
     * Consumer for close event on this menu.
     *
     * @param consumer Consumer for close event.
     */
    fun onClose(consumer: Consumer<InventoryCloseEvent>)

    /**
     * Open this menu for some player.
     */
    fun open(player: Player)

    /**
     * Get item from items map in menu.
     *
     * @param slot Number of slot.
     */
    fun getItem(slot: Int): MenuItem? = items[slot]

    /**
     * Set item in slot.
     *
     * @param slot Number of slot.
     * @param item Item for setting. Use null for removing item from slot.
     */
    fun setItem(slot: Int, item: MenuItem?)

    override fun iterator(): Iterator<Map.Entry<Int, MenuItem>> = items.iterator()

}