package xyz.axie.clans

import org.bukkit.plugin.java.JavaPlugin
import xyz.axie.clans.clan.ClanManager
import xyz.axie.clans.menu.ItemFactory
import xyz.axie.clans.menu.MenuFactory
import xyz.axie.clans.player.PlayerManager
import xyz.axie.economy.Economy

class AfterClans : JavaPlugin(), ClansPlugin {

    override val clanManager: ClanManager
        get() = TODO("Not yet implemented")
    override val playerManager: PlayerManager
        get() = TODO("Not yet implemented")
    override val menuFactory: MenuFactory
        get() = TODO("Not yet implemented")
    override val itemFactory: ItemFactory
        get() = TODO("Not yet implemented")

    lateinit var mainCurrency: Economy<Double>
    lateinit var additionalCurrency: Economy<Int>

    override fun onEnable() {
        mainCurrency = EconomyResolver.resolve(EconomyModel.VAULT)
        additionalCurrency = EconomyResolver.resolve(EconomyModel.PLAYER_POINTS)

        println("Main currency configured with ${mainCurrency.name}")
        println("Additional currency configured with ${additionalCurrency.name}")
    }

}