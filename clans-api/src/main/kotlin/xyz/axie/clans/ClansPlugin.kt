package xyz.axie.clans

import xyz.axie.clans.clan.ClanManager
import xyz.axie.clans.menu.ItemFactory
import xyz.axie.clans.menu.MenuFactory
import xyz.axie.clans.player.PlayerManager

/**
 * This interface represents main class of clans plugin.
 */
interface ClansPlugin {

    /**
     * Clan manager of plugin.
     */
    val clanManager: ClanManager

    /**
     * Player manager of plugin.
     */
    val playerManager: PlayerManager

    /**
     * Factory of menus.
     */
    val menuFactory: MenuFactory

    /**
     * Menu items factory.
     */
    val itemFactory: ItemFactory

}