package xyz.axie.clans.clan

import net.kyori.adventure.text.Component
import org.bukkit.Location
import xyz.axie.clans.player.ClanPlayer
import xyz.axie.clans.player.PlayerSettings

class CraftClan(
    override var owner: ClanPlayer
) : Clan {
    override var name: Component
        get() = TODO("Not yet implemented")
        set(value) {}
    override val strippedName: String
        get() = TODO("Not yet implemented")
    override val settings: ClanSettings
        get() = TODO("Not yet implemented")
    override val storage: ClanStorage
        get() = TODO("Not yet implemented")
    override val members: Map<ClanPlayer, PlayerSettings>
        get() = TODO("Not yet implemented")

    override fun addMember(member: ClanPlayer): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeMember(member: ClanPlayer) {
        TODO("Not yet implemented")
    }

    override val levelMapping: LevelMapping
        get() = TODO("Not yet implemented")
    override var exp: Long
        get() = TODO("Not yet implemented")
        set(value) {}
    override val level: Int
        get() = TODO("Not yet implemented")
    override var balance: Long
        get() = TODO("Not yet implemented")
        set(value) {}
    override val homes: Set<String>
        get() = TODO("Not yet implemented")

    override fun addHome(name: String, location: Location) {
        TODO("Not yet implemented")
    }

    override fun removeHome(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getHome(name: String): Location? {
        TODO("Not yet implemented")
    }

}