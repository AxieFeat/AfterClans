package xyz.axie.economy.vault

import net.milkbowl.vault.economy.EconomyResponse
import org.bukkit.Bukkit
import xyz.axie.economy.Economy
import java.util.*

object VaultEconomy : Economy<Double> {

    override val name: String = "vault"

    private var econ: net.milkbowl.vault.economy.Economy? = null

    override fun hook() {
        if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
            val rsp =
                Bukkit.getServer().servicesManager.getRegistration(net.milkbowl.vault.economy.Economy::class.java)

            econ = rsp?.getProvider() ?: throw UnsupportedOperationException("Error during Vault hook!")
            return
        }

        throw UnsupportedOperationException("Vault plugin not found!")
    }

    override fun get(uuid: UUID): Double {
        return econ?.getBalance(Bukkit.getOfflinePlayer(uuid)) ?: 0.0
    }

    override fun set(uuid: UUID, amount: Double) {
        val target = Bukkit.getOfflinePlayer(uuid)
        val currentPlayersBalance = econ?.getBalance(target) ?: 0.0
        val difference = currentPlayersBalance - amount

        if(difference > 0.0){
            econ?.depositPlayer(target, difference);
        } else {
            econ?.withdrawPlayer(target, -difference);
        }
    }

    override fun add(uuid: UUID, amount: Double): Boolean {
        return econ?.depositPlayer(Bukkit.getOfflinePlayer(uuid), amount)?.type == EconomyResponse.ResponseType.SUCCESS
    }

    override fun take(uuid: UUID, amount: Double): Boolean {
        return econ?.withdrawPlayer(Bukkit.getOfflinePlayer(uuid), amount)?.type == EconomyResponse.ResponseType.SUCCESS
    }

}