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
    val maxNameLength: Int

    /**
     * Max balance for clan.
     */
    val maxBalance: Long

    /**
     * Max count of members in clan.
     */
    val maxMembers: Int

    /**
     * Max homes count in clan.
     */
    val maxHomes: Int

    /**
     * Count of unique items in clan storage.
     */
    val storageSize: Int

    /**
     * Is allowed to deal damage among your clan's disciples?
     */
    @get:JvmName("isDamageAllowed")
    val isDamageAllowed: Boolean

    /**
     * Is glow effect enabled in clan?
     */
    @get:JvmName("isGlowing")
    val isGlowing: Boolean

    /**
     * Color of glowing in clan.
     */
    val glowColor: Color

}