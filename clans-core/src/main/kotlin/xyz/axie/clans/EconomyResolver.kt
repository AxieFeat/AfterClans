package xyz.axie.clans

import xyz.axie.economy.Economy
import xyz.axie.economy.playerpoints.PlayerPointEconomy
import xyz.axie.economy.stub.StubEconomy
import xyz.axie.economy.vault.VaultEconomy

/**
 * This class represents resolver for economy implementations.
 */
@Suppress("UNCHECKED_CAST")
object EconomyResolver {

    /**
     * Get economy of some type.
     *
     * @param model Target economy model.
     * @param fallback Fallback economy if target [model] not available.
     *
     * @return Instance of [Economy].
     *
     * @throws IllegalArgumentException If target model accept other
     */
    @JvmStatic
    @Throws(IllegalArgumentException::class)
    inline fun <reified T: Number> resolve(model: EconomyModel, fallback: EconomyModel = EconomyModel.STUB): Economy<T> {
        try {
            val instance = when(model) {
                EconomyModel.VAULT -> VaultEconomy
                EconomyModel.PLAYER_POINTS -> PlayerPointEconomy
                EconomyModel.STUB -> StubEconomy<T>()
            } as Economy<T>

            instance.hook()

            return instance
        } catch (ignore: Exception) { }

        try {
            val instance = when(fallback) {
                EconomyModel.VAULT -> VaultEconomy
                EconomyModel.PLAYER_POINTS -> PlayerPointEconomy
                EconomyModel.STUB -> StubEconomy<T>()
            } as Economy<T>

            instance.hook()

            return instance
        } catch(e: Exception) {
            throw IllegalArgumentException("Bad type of currency.", e)
        }
    }

}