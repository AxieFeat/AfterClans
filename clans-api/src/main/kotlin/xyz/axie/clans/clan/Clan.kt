package xyz.axie.clans.clan

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.audience.ForwardingAudience
import net.kyori.adventure.text.Component
import org.bukkit.Location
import xyz.axie.clans.nbt.CompoundTagHolder
import xyz.axie.clans.player.ClanPlayer

/**
 * This interface represents some clan.
 *
 * It implements [ForwardingAudience] and you can use all methods of Adventure API, like message sending.
 * It also implements [CompoundTagHolder] and you can store any data in it.
 */
interface Clan : ForwardingAudience, CompoundTagHolder {

    /**
     * Display name of clan.
     */
    var name: Component

    /**
     * Stripped [name] of clan (without any formatting).
     *
     * It should be unique and not repeats.
     */
    val strippedName: String

    /**
     * Storage of this clan.
     */
    val storage: ClanStorage

    /**
     * Owner of clan. He has absolutely all permissions for control clan.
     */
    var owner: ClanPlayer

    /**
     * All members of clan, include [owner].
     */
    val members: Set<ClanPlayer>

    /**
     * Adds member in clan. If [member] already have some clan - it should be kicked from it and joined to this.
     *
     * @param member Member to add.
     *
     * @return Status of adding. `true` if success, otherwise `false`.
     */
    fun addMember(member: ClanPlayer): Boolean

    /**
     * Remove member from clan.
     *
     * @param member Member to remove.
     */
    fun removeMember(member: ClanPlayer)

    /**
     * Mapping for levels. It calculates levels by experience count.
     *
     * Example:
     *   - For 1 level your need 1000 exp.
     *   - For 2 level your need `previous-level-exp` * 1.5 exp.
     *   - And more, more...
     *
     * @see LevelMapping
     */
    val levelMapping: LevelMapping

    /**
     * Current experience count of clan.
     *
     * Should not be lower `0`.
     *
     * If trying to set value `<0`, that should be set to `0` in any case.
     */
    var exp: Long

    /**
     * Level of clan. It calculated automatically by [levelMapping].
     *
     * For optimization should save value and update it only, if count of [exp] was updated.
     */
    val level: Int

    /**
     * Add experience for clan.
     *
     * @param exp Count of experience to add. Can be negative for taking.
     *
     * @return `true` if new exp was up level, otherwise `false`.
     */
    fun addExp(exp: Long): Boolean {
        val old = level
        this.exp += exp
        val new = level

        return old > new
    }

    /**
     * Set level by setting count of exp, that need for getting this level.
     *
     * It should overwrite old exp value by new.
     */
    fun setExpByLevel(level: Int) {
        this.exp = levelMapping.getExpForLevel(level)
    }

    /**
     * Balance of clan. Can be negative also.
     *
     * If value of [balance] more, than [ClanSettings.maxBalance] it should be set to max value.
     */
    var balance: Long

    /**
     * Add balance to clan. Negative values for taking.
     *
     * @param amount Amount of money for adding.
     */
    fun addBalance(amount: Long) {
        this.balance += amount
    }

    /**
     * Set of all clan-homes in clan.
     */
    val homes: Set<String>

    /**
     * Add clan-home to this clan.
     *
     * If size of [homes] is more, than [ClanSettings.maxHomes] adding of all new clan-homes should be ignored.
     *
     * @param name Name of home. If already exist - should be overwritten.
     * @param location Location of clan-home.
     */
    fun addHome(name: String, location: Location)

    /**
     * Remove clan-home from clan.
     *
     * @param name Name of clan-home.
     *
     * @return Status of removing. `true` if success, otherwise `false`.
     */
    fun removeHome(name: String): Boolean

    /**
     * Get clan-home location by it [name].
     *
     * @param name Name of clan-home.
     *
     * @return Instance of location or null, if not found.
     */
    fun getHome(name: String): Location?

    override fun audiences(): Iterable<Audience> = members

}