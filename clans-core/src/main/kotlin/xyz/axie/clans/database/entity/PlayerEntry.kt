package xyz.axie.clans.database.entity

import org.jdbi.v3.sqlobject.config.RegisterColumnMapper
import xyz.axie.clans.database.mapper.PlayerSettingsColumnMapper
import xyz.axie.clans.database.mapper.UUIDColumnMapper
import xyz.axie.clans.player.PlayerSettings
import java.beans.ConstructorProperties
import java.util.*

@RegisterColumnMapper(value = UUIDColumnMapper::class)
@RegisterColumnMapper(value = PlayerSettingsColumnMapper::class)
data class PlayerEntry @ConstructorProperties(
    "member_uuid",
    "member_name",
    "clan_owner_uuid",
    "member_settings"
) constructor(
    val uuid: UUID,
    val name: String,
    val clan: UUID,
    val settings: PlayerSettings
)