package xyz.axie.clans.player

import net.kyori.adventure.audience.Audience
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import xyz.axie.clans.clan.Clan
import java.util.UUID

/**
 * This interface represents player of clan.
 *
 * It implements [Audience] and you can use all methods of Adventure API, like message sending.
 * But it will work only if player is online.
 */
interface ClanPlayer : Audience {

    /**
     * UUID of this player.
     */
    val uuid: UUID

    /**
     * Name of this clan player.
     */
    val name: String

    /**
     * Clan of this player. Null if not have clan.
     *
     * If you add player to clan via setting this property - all limiters of [xyz.axie.clans.clan.ClanSettings] should be ignored.
     *
     * For adding player to clan recommended use [Clan.addMember].
     */
    var clan: Clan?

    /**
     * Player settings in this clan. Null if [clan] is null.
     *
     * Should be reset to default if [clan] of player was changed.
     */
    var settings: PlayerSettings?

    /**
     * Is this player has clan.
     *
     * @return `true` if player has clan, otherwise `false`.
     */
    fun hasClan(): Boolean = clan != null

    /**
     * Is this player owner of some clan.
     *
     * @return `true` if player is owner of some clan, otherwise `false`.
     */
    fun isOwner(): Boolean = clan?.owner == this

    /**
     * Get bukkit player from this. Can return null if player is offline.
     *
     * @return Instance of [Player], or null if offline.
     */
    fun asBukkit(): Player? = Bukkit.getPlayer(uuid)

    /**
     * Get bukkit offline player.
     *
     * Please note that there is no full guarantee that this function will return an offline player.
     * The server may not know about this player, for example, if you are using a multi-server system and the player
     * has not joined anytime into this particular server.
     *
     * @return Instance of [OfflinePlayer].
     */
    fun asBukkitOffline(): OfflinePlayer = Bukkit.getOfflinePlayer(uuid)

    /**
     * Is this player in online
     *
     * This function does not take into account and does not support multi-server checking.
     * If clans are merged on multiple servers,
     * you will not be able to check an online player from another server.
     *
     * @return `true` if player online, otherwise `false`.
     */
    fun isOnline(): Boolean = asBukkit()?.isOnline == true

}