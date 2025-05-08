package xyz.axie.clans.database.mysql

import org.jdbi.v3.sqlobject.config.RegisterArgumentFactory
import org.jdbi.v3.sqlobject.config.RegisterColumnMapper
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import xyz.axie.clans.clan.Clan
import xyz.axie.clans.database.argument.PlayerSettingsArgumentFactory
import xyz.axie.clans.database.argument.UUIDArgumentFactory
import xyz.axie.clans.database.common.PlayerDAO
import xyz.axie.clans.database.entity.PlayerEntry
import xyz.axie.clans.database.mapper.UUIDColumnMapper
import xyz.axie.clans.player.PlayerSettings
import java.util.*

@RegisterArgumentFactory(value = UUIDArgumentFactory::class)
@RegisterArgumentFactory(value = PlayerSettingsArgumentFactory::class)
@RegisterColumnMapper(value = UUIDColumnMapper::class)
interface PlayerDAOMySQL : PlayerDAO {

    @SqlUpdate("""
        INSERT INTO clan_members (member_uuid, member_name, clan_owner_uuid, member_settings)
        VALUES (:UUID, :NAME, :CLAN.owner.uuid, :SETTINGS)
    """)
    override fun createPlayer(@Bind("UUID") uuid: UUID, @Bind("NAME") name: String, @Bind("CLAN") clan: Clan, @Bind("SETTINGS") settings: PlayerSettings)

    @SqlQuery("""
        SELECT * FROM clan_members WHERE member_uuid = :UUID
    """)
    @RegisterConstructorMapper(value = PlayerEntry::class)
    override fun getPlayer(@Bind("UUID") uuid: UUID): PlayerEntry?

    @SqlQuery("""
        SELECT EXISTS(SELECT 1 FROM clan_members WHERE member_uuid = :UUID)
    """)
    override fun isPlayerExists(@Bind("UUID") uuid: UUID): Boolean

    @SqlUpdate("""
        UPDATE clan_members
        SET clan_owner_uuid = :CLAN.owner.uuid
        WHERE member_uuid = :UUID
    """)
    override fun setPlayerClan(@Bind("UUID") uuid: UUID, @Bind("CLAN") clan: Clan)

    @SqlUpdate("""
        UPDATE clan_members
        SET member_settings = :SETTINGS
        WHERE member_uuid = :UUID
    """)
    override fun setPlayerSettings(@Bind("UUID") uuid: UUID, @Bind("SETTINGS") settings: PlayerSettings)

}