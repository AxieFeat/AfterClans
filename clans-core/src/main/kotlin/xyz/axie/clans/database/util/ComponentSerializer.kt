package xyz.axie.clans.database.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

object ComponentSerializer {

    @JvmStatic
    private val miniMessage = MiniMessage.builder().build()

    @JvmStatic
    fun Component.serialize(): String {
        return miniMessage.serialize(this)
    }

    @JvmStatic
    fun String.deserializeComponent(): Component {
        return miniMessage.deserialize(this)
    }

}