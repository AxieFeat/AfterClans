package xyz.axie.clans

import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import xyz.axie.clans.clan.ClanManager
import xyz.axie.clans.economy.EconomyModel
import xyz.axie.clans.economy.EconomyResolver
import xyz.axie.clans.economy.EconomyUsage
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

    private lateinit var mainCurrency: Economy<Int>
    private lateinit var additionalCurrency: Economy<Int>

    override fun onEnable() {
        mainCurrency = EconomyResolver.resolve(EconomyModel.VAULT)
        additionalCurrency = EconomyResolver.resolve(EconomyModel.PLAYER_POINTS)

        startKoin {
            modules(
                module {
                    single(named(EconomyUsage.MAIN)) { mainCurrency }
                    single(named(EconomyUsage.ADDITIONAL)) { additionalCurrency }
                }
            )
        }
    }

}