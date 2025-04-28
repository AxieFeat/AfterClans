package xyz.axie.clans.clan

/**
 * This interface allows to calculate level by count of experience.
 */
interface LevelMapping {

    /**
     * Max level of this mapping.
     *
     * You can use [Int.MAX_VALUE] for 'unlimited'.
     */
    val maxLevel: Int

    /**
     * Get count of exp for some level.
     *
     * @param clan Clan instance for getting it level.
     *
     * @return Level of clan.
     */
    fun levelOf(clan: Clan): Int

    /**
     * Gets count of experience for some level.
     *
     * @param level Level for getting experience count.
     *
     * @return Experience count.
     */
    fun getExpForLevel(level: Int): Long

}