package xyz.axie.clans.clan

import net.kyori.adventure.text.Component
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

/**
 * This interface represents manager for clans.
 */
interface ClanManager {

    /**
     * All memory-saved clans.
     *
     * Key - UUID of clan owner, Value - Instance of [Clan].
     */
    val clans: Map<UUID, Clan>

    /**
     * Get or load clan by owner [UUID].
     *
     * It will return clan from [clans] map or load via [loadClan] if it is not saved yet.
     *
     * @param owner UUID of owner.
     *
     * @return Completion stage with clan instance.
     */
    fun getOrLoad(owner: UUID): CompletionStage<Clan?> {
        if(clans.containsKey(owner)) return CompletableFuture.completedFuture(clans[owner])

        return loadClan(owner)
    }

    /**
     * Load clan by owner [UUID].
     *
     * @param owner UUID of owner.
     *
     * @return Completion stage with clan instance.
     */
    fun loadClan(owner: UUID): CompletionStage<Clan?>

    /**
     * Delete clan by owner [UUID].
     *
     * @param owner UUID of owner.
     */
    fun deleteClan(owner: UUID)

    /**
     * Is clan exists.
     *
     * @param owner UUID of owner.
     *
     * @return Completion stage with result.
     */
    fun clanExists(owner: UUID): CompletionStage<Boolean>

    /**
     * Create new clan.
     *
     * @param owner UUID of owner.
     * @param name Name of clan.
     *
     * @return Completion stage with clan instance.
     */
    fun createClan(owner: UUID, name: Component): CompletionStage<Clan>

}