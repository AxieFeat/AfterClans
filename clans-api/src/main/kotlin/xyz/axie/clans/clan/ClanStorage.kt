package xyz.axie.clans.clan

import org.bukkit.inventory.ItemStack
import xyz.axie.nbt.CompoundTag
import xyz.axie.nbt.MutableCompoundTag

/**
 * This interface represents storage of items in clan.
 */
interface ClanStorage {

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

    /**
     * Build current instance to compound tag.
     *
     * @return New instance of [CompoundTag].
     */
    fun build(): CompoundTag

    /**
     * Write clan storage items to compound tag.
     *
     * @param compound Compound for writing.
     *
     * @return Given instance of [MutableCompoundTag].
     */
    fun write(compound: MutableCompoundTag): MutableCompoundTag {
        compound.put("items", build())

        return compound
    }

    /**
     * Read values from compound tag and write it to current instance.
     *
     * @param compound Compound with items.
     *
     * @return Current instance of [ClanStorage]
     */
    fun read(compound: CompoundTag): ClanStorage

}