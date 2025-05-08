package xyz.axie.clans.database.common

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.Location
import org.bukkit.inventory.ItemStack
import xyz.axie.clans.clan.ClanSettings
import xyz.axie.clans.database.entity.ClanEntry
import xyz.axie.clans.player.ClanPlayer

/**
 * This interface represents common DAO for clans.
 */
interface ClanDAO {

    /**
     * Create new clan.
     *
     * @param owner Owner of clan.
     * @param name Name of clan.
     * @param stripped Stripped name of clan.
     */
    fun createClan(owner: ClanPlayer, name: Component, stripped: String = PlainTextComponentSerializer.plainText().serialize(name))

    /**
     * Delete some clan.
     *
     * @param owner Owner of clan for delete.
     */
    fun deleteClan(owner: ClanPlayer)



    /**
     * Get all stripped names of clans.
     *
     * @return Set of stripped names.
     */
    fun getAllClanStrippedNames(): Set<String>

    /**
     * Get clan entry by clan owner.
     *
     * For checking existing use [isClanExists], its more fast.
     *
     * @param owner Clan owner.
     *
     * @return Clan entry or null, if not found.
     */
    fun getClan(owner: ClanPlayer): ClanEntry?

    /**
     * Get clan by it stripped name.
     *
     * For checking existing use [isClanExists], its more fast.
     *
     * @param stripped Stripped name.
     *
     * @return Clan entry or null, if not found.
     */
    fun getClanByStrippedName(stripped: String): ClanEntry?

    /**
     * Is player owner of some clan.
     *
     * @param owner Owner of clan.
     *
     * @return Is this player owner of some clan.
     */
    fun isClanExists(owner: ClanPlayer): Boolean



    /**
     * Set name of clan.
     *
     * @param owner Owner of clan.
     * @param name New name of clan.
     * @param stripped Stripped name of clan.
     */
    fun setClanName(owner: ClanPlayer, name: Component, stripped: String = PlainTextComponentSerializer.plainText().serialize(name))

    /**
     * Set new clan owner.
     *
     * @param oldOwner Old owner of clan.
     * @param newOwner New owner of clan.
     */
    fun setClanOwner(oldOwner: ClanPlayer, newOwner: ClanPlayer)

    /**
     * Set clan balance.
     *
     * @param owner Owner of clan.
     * @param balance Balance to set.
     */
    fun setClanBalance(owner: ClanPlayer, balance: Long)

    /**
     * Set exp of clan.
     *
     * @param owner Owner of clan.
     * @param exp Exp to set.
     */
    fun setClanExp(owner: ClanPlayer, exp: Long)

    /**
     * Set settings of clan.
     *
     * @param owner Owner of clan.
     * @param settings Settings to set.
     */
    fun setClanSettings(owner: ClanPlayer, settings: ClanSettings)



    /**
     * Set item in clan storage.
     *
     * @param owner Owner of clan.
     * @param slot Slot in storage.
     * @param item Item to set, null for removing.
     */
    fun setClanStorageItem(owner: ClanPlayer, slot: Int, item: ItemStack?)

    /**
     * Get item from clan storage.
     *
     * @param owner Owner of clan.
     * @param slot Slot in storage.
     */
    fun getClanStorageItem(owner: ClanPlayer, slot: Int): ItemStack?



    /**
     * Get all clan-home names of clan.
     *
     * @param owner Owner of clan.
     *
     * @return Set of clan-home names.
     */
    fun getAllClanHomeNames(owner: ClanPlayer): Set<String>

    /**
     * Get clan-home.
     *
     * For checking existing use [isClanHomeExists], its more fast.
     *
     * @param owner Owner of clan.
     * @param name Name of clan-home.
     *
     * @return Instance of [Location] or null, if not found.
     */
    fun getClanHome(owner: ClanPlayer, name: String): Location?

    /**
     * Checks existing of home.
     *
     * @param owner Owner of clan.
     * @param name Name of clan-home.
     *
     * @return `true` if home exists, otherwise `false`.
     */
    fun isClanHomeExists(owner: ClanPlayer, name: String): Boolean

    /**
     * Set clan-home.
     *
     * @param owner Owner of clan.
     * @param name Name of clan-home.
     * @param location Location to set. Null for deleting home.
     */
    fun setClanHome(owner: ClanPlayer, name: String, location: Location?)

}