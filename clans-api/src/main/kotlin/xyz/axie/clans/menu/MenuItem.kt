package xyz.axie.clans.menu

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataHolder
import java.util.function.Consumer

/**
 * This interface represents item in some menu.
 */
interface MenuItem : PersistentDataHolder {

    /**
     * Bukkit presentation of this item.
     */
    var item: ItemStack

    /**
     * Consumer for clicking on this item.
     *
     * @param consumer Consumer of click event.
     */
    fun onClick(consumer: Consumer<InventoryClickEvent>)

}