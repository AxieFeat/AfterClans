package xyz.axie.clans.player

import net.kyori.adventure.text.Component
import org.bukkit.Color
import java.util.*

/**
 * This interface represents some settings of player in clan.
 */
@Suppress("INAPPLICABLE_JVM_NAME")
interface PlayerSettings {

    /**
     * Prefix of this player in clan.
     */
    val prefix: Component

    /**
     * Map of all player permissions.
     *
     * * Key - [Permission.id]
     * * Value - Some value of permission. Use [Permission.parse] for parsing.
     */
    val permissions: Map<String, *>

    /**
     * Is this player view glow on other players (Personal setting)?
     */
    @get:JvmName("isGlowing")
    val isGlowing: Boolean

    /**
     * Glow color settings for each specific player (Viewable only for this player).
     */
    val glowSetting: Map<UUID, Color>

    /**
     * Create new [PlayerSettings] with new [prefix].
     *
     * @return New instance of [PlayerSettings].
     */
    fun withPrefix(prefix: Component): PlayerSettings

    /**
     * Create new [PlayerSettings] with added [permission]. It should save old values in map.
     *
     * @return New instance of [PlayerSettings].
     */
    fun withPermission(vararg permission: Pair<Permission<*>, *>): PlayerSettings

    /**
     * Create new [PlayerSettings] without some [permission].
     *
     * @return New instance of [PlayerSettings].
     */
    fun <T> withoutPermission(vararg permission: Permission<*>): PlayerSettings

    /**
     * Create new [PlayerSettings] with new [permissions]. It should delete old values.
     *
     * @return New instance of [PlayerSettings].
     */
    fun withPermissions(permissions: Map<Permission<*>, *>): PlayerSettings

    /**
     * Create new [PlayerSettings] with changed [isGlowing] status.
     *
     * @return New instance of [PlayerSettings].
     */
    fun withGlowing(isGlowing: Boolean): PlayerSettings

    /**
     * Create new [PlayerSettings] with added [glowSetting]. It should save old values in map.
     *
     * @return New instance of [PlayerSettings].
     */
    fun withGlowingSetting(vararg glowing: Pair<UUID, Color>): PlayerSettings

    /**
     * Create new [PlayerSettings] with new [glowSetting]. It should delete old values.
     *
     * @return New instance of [PlayerSettings].
     */
    fun withGlowingSettings(glowing: Map<UUID, Color>): PlayerSettings

    /**
     * Create new [PlayerSettings] without some player.
     *
     * @return New instance of [PlayerSettings].
     */
    fun withoutGlowingSetting(vararg glowing: UUID): PlayerSettings

}