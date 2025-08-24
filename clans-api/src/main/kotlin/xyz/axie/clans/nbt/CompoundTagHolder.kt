package xyz.axie.clans.nbt

import xyz.axie.nbt.MutableCompoundTag

/**
 * This interface represents holder of compound tag.
 */
interface CompoundTagHolder {

    /**
     * Compound tag, that this object store.
     */
    var compound: MutableCompoundTag

}