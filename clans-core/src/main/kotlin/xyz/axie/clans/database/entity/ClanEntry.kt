package xyz.axie.clans.database.entity

import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.jdbi.v3.sqlobject.config.RegisterColumnMapper
import xyz.axie.clans.clan.ClanSettings
import xyz.axie.clans.database.mapper.ClanSettingsColumnMapper
import xyz.axie.clans.database.mapper.ComponentColumnMapper
import xyz.axie.clans.database.mapper.ItemStackMapColumnMapper
import xyz.axie.clans.database.mapper.LocationMapMapper
import xyz.axie.clans.database.mapper.UUIDColumnMapper
import xyz.axie.clans.database.mapper.UUIDSetColumnMapper
import java.beans.ConstructorProperties
import java.util.*
import javax.xml.stream.Location

@RegisterColumnMapper(value = UUIDColumnMapper::class)
@RegisterColumnMapper(value = ComponentColumnMapper::class)
@RegisterColumnMapper(value = ClanSettingsColumnMapper::class)
@RegisterColumnMapper(value = UUIDSetColumnMapper::class)
@RegisterColumnMapper(value = LocationMapMapper::class)
@RegisterColumnMapper(value = ItemStackMapColumnMapper::class)
data class ClanEntry @ConstructorProperties(
    "clan_owner_uuid",
    "name",
    "stripped_name",
    "balance",
    "exp",
    "clan_settings",
    "members",
    "storage",
    "homes"
) constructor(
    val uuid: UUID,
    val name: Component,
    val strippedName: String,
    val balance: Long,
    val exp: Long,
    val clanSettings: ClanSettings,
    val members: Set<UUID>,
    val homes: Map<String, Location>,
    val storage: Map<Int, ItemStack>
)