package xyz.axie.clans.player

import net.kyori.adventure.audience.Audience
import org.bukkit.Bukkit
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
     */
    val clan: Clan?

    /**
     * Is this player has clan.
     *
     * @return `true` if player has clan, otherwise `false`.
     */
    fun hasClan(): Boolean = clan != null

    /**
     * Is this player owner of some clan.
     *
     * @return `tru` if player is owner of some clan, otherwise `false`.
     */
    fun isOwner(): Boolean = hasClan() && clan!!.owner == this

    /**
     * Get bukkit player from this. Can return null if player is offline.
     *
     * @return Instance of [Player], or null if offline.
     */
    fun asBukkit(): Player? = Bukkit.getPlayer(uuid)

    /**
     * Is this player in online.
     *
     * @return `true` if player online, otherwise `false`.
     */
    fun isOnline(): Boolean = asBukkit() != null

}