package xyz.axie.clans.menu

import org.bukkit.Material
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import java.util.function.Consumer

/**
 * This interface represents factory for menu items.
 */
interface ItemFactory {

    /**
     * Create new menu item.
     *
     * @param item Bukkit [ItemStack].
     * @param consumer Consumer for click event.
     *
     * @return New instance of [MenuItem].
     */
    fun create(
        item: ItemStack = ItemStack(Material.AIR),
        consumer: Consumer<InventoryClickEvent> = Consumer { }
    ): MenuItem

}