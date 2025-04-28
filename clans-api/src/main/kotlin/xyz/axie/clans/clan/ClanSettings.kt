package xyz.axie.clans.clan

import org.bukkit.Color

/**
 * This interface represents settings of clan.
 */
@Suppress("INAPPLICABLE_JVM_NAME")
interface ClanSettings {

    /**
     * Max length of name for clan.
     */
    var maxNameLength: Int

    /**
     * Max balance for clan.
     */
    var maxBalance: Long

    /**
     * Max count of members in clan.
     */
    var maxMembers: Int

    /**
     * Max homes count in clan.
     */
    var maxHomes: Int

    /**
     * Count of unique items in clan storage.
     */
    var storageSize: Int

    /**
     * Is allowed to deal damage among your clan's disciples?
     */
    @get:JvmName("isDamageAllowed")
    @set:JvmName("setDamageAllowed")
    var isDamageAllowed: Boolean

    /**
     * Is glow effect enabled in clan?
     */
    @get:JvmName("isGlowing")
    @set:JvmName("setGlowing")
    var isGlowing: Boolean

    /**
     * Color of glowing in clan.
     */
    var glowColor: Color

}