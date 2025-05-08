package xyz.axie.clans.economy

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
     * @param target Target economy model.
     * @param fallback Fallback economy if target [target] not available.
     *
     * @return Instance of [Economy].
     */
    @JvmStatic
    inline fun <reified T: Number> resolve(target: EconomyModel, fallback: EconomyModel = EconomyModel.STUB): Economy<T> {
        try {
            val instance = when(target) {
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
            throw IllegalArgumentException("Bad type of currency [$fallback]", e)
        }
    }

}