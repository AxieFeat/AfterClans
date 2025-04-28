package xyz.axie.clans.player

import org.bukkit.OfflinePlayer
import java.util.*

/**
 * This interface represents manager for clan players.
 */
interface PlayerManager {

    /**
     * All registered players in memory.
     */
    val players: Map<UUID, ClanPlayer>

    /**
     * Get player from registered [players].
     *
     * @param uuid UUID of player.
     *
     * @return Instance of [ClanPlayer] or null, if not found. It also returns null, if player not registered.
     */
    fun getPlayer(uuid: UUID): ClanPlayer? = players[uuid]

    /**
     * Get player from registered [players].
     *
     * @param player Instance of offline player.
     *
     * @return Instance of [ClanPlayer] or null, if not found. It also returns null, if player not registered.
     */
    fun getPlayer(player: OfflinePlayer): ClanPlayer? = players[player.uniqueId]

    /**
     * Is player with specific [uuid] registered.
     *
     * @param uuid UUID of player.
     *
     * @return `true` if registered, otherwise `false`.
     */
    fun isRegistered(uuid: UUID): Boolean = players.containsKey(uuid)

    /**
     * Is player with specific uuid registered.
     *
     * @param player Instance of offline player.
     *
     * @return `true` if registered, otherwise `false`.
     */
    fun isRegistered(player: OfflinePlayer): Boolean = players.containsKey(player.uniqueId)

    /**
     * Register player in memory (save it to [players]).
     *
     * @param uuid UUID of player.
     */
    fun register(uuid: UUID)

}