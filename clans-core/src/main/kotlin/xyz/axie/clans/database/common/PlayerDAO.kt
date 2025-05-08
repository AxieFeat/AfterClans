package xyz.axie.clans.database.common

import xyz.axie.clans.clan.Clan
import xyz.axie.clans.database.entity.PlayerEntry
import xyz.axie.clans.player.PlayerSettings
import java.util.*

/**
 * This interface represents common DAO for players.
 */
interface PlayerDAO {

    /**
     * Creates new player.
     *
     * @param uuid UUID of player.
     * @param name Name of player.
     * @param clan Clan of player.
     * @param settings Setting of player.
     */
    fun createPlayer(uuid: UUID, name: String, clan: Clan, settings: PlayerSettings)

    /**
     * Get player by uuid.
     *
     * For checking existing use [isPlayerExists], its more fast.
     *
     * @param UUID UUID of player.
     *
     * @return Player entry or null, if not found.
     */
    fun getPlayer(uuid: UUID): PlayerEntry?

    /**
     * Is player with some uuid exists.
     *
     * @param uuid UUID to check.
     *
     * @return `true` if player exists, otherwise `false`.
     */
    fun isPlayerExists(uuid: UUID): Boolean

    /**
     * Set clan of player.
     *
     * @param uuid UUID of player.
     * @param clan Clan to set.
     */
    fun setPlayerClan(uuid: UUID, clan: Clan)

    /**
     * Set player settings in this clan.
     *
     * @param uuid UUID of player.
     * @param settings Settings of player.
     */
    fun setPlayerSettings(uuid: UUID, settings: PlayerSettings)

}