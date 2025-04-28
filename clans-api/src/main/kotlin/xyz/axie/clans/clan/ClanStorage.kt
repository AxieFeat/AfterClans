package xyz.axie.clans.clan

import org.bukkit.inventory.ItemStack

/**
 * This interface represents storage of items in clan.
 */
interface ClanStorage {

    /**
     * Clan of this storage.
     */
    val clan: Clan

    /**
     * Items in storage.
     */
    val items: List<ItemStack>

    /**
     * Add item to storage.
     *
     * If count of unique items in [items] is more, than [ClanSettings.storageSize] adding new items will be ignored.
     *
     * @param item Item to add.
     */
    fun addItem(item: ItemStack)

    /**
     * Removes item from storage.
     *
     * @param item Item to remove.
     */
    fun removeItem(item: ItemStack)

}