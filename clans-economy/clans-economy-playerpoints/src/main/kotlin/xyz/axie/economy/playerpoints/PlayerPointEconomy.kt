package xyz.axie.economy.playerpoints

import org.black_ixx.playerpoints.PlayerPoints
import org.black_ixx.playerpoints.PlayerPointsAPI
import org.bukkit.Bukkit
import xyz.axie.economy.Economy
import java.util.*

object PlayerPointEconomy : Economy<Int> {

    private var ppAPI: PlayerPointsAPI? = null

    override val name: String = "playerpoints"

    override fun hook() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.ppAPI = PlayerPoints.getInstance().api
            return
        }

        throw UnsupportedOperationException("PlayerPoint plugin not found!")
    }

    override fun get(uuid: UUID): Int {
        return ppAPI?.look(uuid) ?: 0
    }

    override fun set(uuid: UUID, amount: Int) {
        ppAPI?.set(uuid, amount)
    }

    override fun add(uuid: UUID, amount: Int): Boolean {
        return ppAPI?.give(uuid, amount) == true
    }

    override fun take(uuid: UUID, amount: Int): Boolean {
        return ppAPI?.take(uuid, amount) == true
    }

}