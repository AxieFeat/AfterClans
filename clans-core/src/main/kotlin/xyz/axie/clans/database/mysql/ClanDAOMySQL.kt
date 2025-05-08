package xyz.axie.clans.database.mysql

import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.inventory.ItemStack
import org.jdbi.v3.sqlobject.config.RegisterArgumentFactory
import org.jdbi.v3.sqlobject.config.RegisterColumnMapper
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import xyz.axie.clans.clan.ClanSettings
import xyz.axie.clans.database.argument.*
import xyz.axie.clans.database.common.ClanDAO
import xyz.axie.clans.database.entity.ClanEntry
import xyz.axie.clans.database.mapper.LocationColumnMapper
import xyz.axie.clans.player.ClanPlayer

@RegisterArgumentFactory(value = UUIDArgumentFactory::class)
@RegisterArgumentFactory(value = LocationArgumentFactory::class)
@RegisterArgumentFactory(value = ComponentArgumentFactory::class)
@RegisterArgumentFactory(value = ItemStackArgumentFactory::class)
@RegisterArgumentFactory(value = ClanSettingsArgumentFactory::class)
interface ClanDAOMySQL : ClanDAO {

    @SqlUpdate("""
        INSERT INTO clans (clan_owner_uuid, name, stripped_name)
        VALUES (:OWNER.uuid, :NAME, :STRIPPED_NAME)
    """)
    override fun createClan(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("NAME") name: Component,
        @Bind("STRIPPED_NAME") stripped: String
    )

    @SqlUpdate("""
        DELETE FROM clans WHERE clan_owner_uuid = :OWNER.uuid
    """)
    override fun deleteClan(@Bind("OWNER") owner: ClanPlayer)

    @SqlQuery("""
        SELECT stripped_name FROM clans
    """)
    override fun getAllClanStrippedNames(): Set<String>

    @SqlQuery("""
        SELECT
            c.clan_owner_uuid,
            c.name,
            c.stripped_name,
            c.balance,
            c.exp,
            c.clan_settings,
            GROUP_CONCAT(DISTINCT HEX(m.member_uuid)) AS members,
            GROUP_CONCAT(DISTINCT CONCAT(h.home_name || ':' || h.home_location)) AS homes,
            GROUP_CONCAT(DISTINCT CONCAT(i.slot || ':' || i.item)) AS storage
        FROM clans c
        LEFT JOIN clan_members m ON c.clan_owner_uuid = m.clan_owner_uuid
        LEFT JOIN clan_homes h ON c.clan_owner_uuid = h.clan_owner_uuid
        LEFT JOIN clan_inventory i ON c.clan_owner_uuid = i.clan_owner_uuid
        WHERE c.clan_owner_uuid = :OWNER.uuid
        GROUP BY c.clan_owner_uuid
    """)
    @RegisterConstructorMapper(value = ClanEntry::class)
    override fun getClan(@Bind("OWNER") owner: ClanPlayer): ClanEntry?

    @SqlQuery("""
        SELECT
            c.clan_owner_uuid,
            c.name,
            c.stripped_name,
            c.balance,
            c.exp,
            c.clan_settings,
            GROUP_CONCAT(DISTINCT HEX(m.member_uuid)) AS members,
            GROUP_CONCAT(DISTINCT CONCAT(h.home_name || ':' || h.home_location)) AS homes,
            GROUP_CONCAT(DISTINCT CONCAT(i.slot || ':' || i.item)) AS storage
        FROM clans c
        LEFT JOIN clan_members m ON c.clan_owner_uuid = m.clan_owner_uuid
        LEFT JOIN clan_homes h ON c.clan_owner_uuid = h.clan_owner_uuid
        LEFT JOIN clan_inventory i ON c.clan_owner_uuid = i.clan_owner_uuid
        WHERE c.stripped_name = :STRIPPED
        GROUP BY c.clan_owner_uuid
    """)
    @RegisterConstructorMapper(value = ClanEntry::class)
    override fun getClanByStrippedName(@Bind("STRIPPED") stripped: String): ClanEntry?

    @SqlQuery("""
        SELECT EXISTS(SELECT 1 FROM clans WHERE clan_owner_uuid = :OWNER.uuid)
    """)
    override fun isClanExists(@Bind("OWNER") owner: ClanPlayer): Boolean

    @SqlUpdate("""
        UPDATE clans 
        SET name = :NAME, stripped_name = :STRIPPED_NAME 
        WHERE clan_owner_uuid = :OWNER.uuid
    """)
    override fun setClanName(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("NAME") name: Component,
        @Bind("STRIPPED_NAME") stripped: String
    )

    @SqlUpdate("""
        UPDATE clans 
        SET clan_owner_uuid = :NEW_OWNER.uuid 
        WHERE clan_owner_uuid = :OLD_OWNER.uuid
    """)
    override fun setClanOwner(
        @Bind("OLD_OWNER") oldOwner: ClanPlayer,
        @Bind("NEW_OWNER") newOwner: ClanPlayer
    )

    @SqlUpdate("""
        UPDATE clans 
        SET balance = :BALANCE 
        WHERE clan_owner_uuid = :OWNER.uuid
    """)
    override fun setClanBalance(@Bind("OWNER") owner: ClanPlayer, @Bind("BALANCE") balance: Long)

    @SqlUpdate("""
        UPDATE clans 
        SET exp = :EXP 
        WHERE clan_owner_uuid = :OWNER.uuid
    """)
    override fun setClanExp(@Bind("OWNER") owner: ClanPlayer, @Bind("EXP") exp: Long)

    @SqlUpdate("""
        UPDATE clans 
        SET clan_settings = :SETTINGS 
        WHERE clan_owner_uuid = :OWNER.uuid
    """)
    override fun setClanSettings(@Bind("OWNER") owner: ClanPlayer, @Bind("SETTINGS") settings: ClanSettings)

    @SqlUpdate("""
        INSERT INTO clan_inventory (clan_owner_uuid, slot, item)
        VALUES (:OWNER.uuid, :SLOT, :ITEM)
        ON DUPLICATE KEY UPDATE item = VALUES(item)
    """)
    override fun setClanStorageItem(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("SLOT") slot: Int,
        @Bind("ITEM") item: ItemStack?
    )

    @SqlQuery("""
        SELECT item 
        FROM clan_inventory 
        WHERE clan_owner_uuid = :OWNER.uuid AND slot = :SLOT
    """)
    override fun getClanStorageItem(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("SLOT") slot: Int
    ): ItemStack?

    @SqlQuery("""
        SELECT home_name 
        FROM clan_homes 
        WHERE clan_owner_uuid = :OWNER.uuid
    """)
    override fun getAllClanHomeNames(@Bind("OWNER") owner: ClanPlayer): Set<String>

    @SqlQuery("""
        SELECT home_location 
        FROM clan_homes 
        WHERE clan_owner_uuid = :OWNER.uuid AND home_name = :NAME
    """)
    @RegisterColumnMapper(value = LocationColumnMapper::class)
    override fun getClanHome(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("NAME") name: String
    ): Location?

    @SqlQuery("""
        SELECT EXISTS(SELECT 1 
                      FROM clan_homes 
                      WHERE clan_owner_uuid = :OWNER.uuid 
                        AND home_name = :NAME)
    """)
    override fun isClanHomeExists(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("NAME") name: String
    ): Boolean

    @SqlUpdate("""
        INSERT INTO clan_homes (clan_owner_uuid, home_name, home_location)
        VALUES (:OWNER.uuid, :NAME, :LOCATION)
        ON DUPLICATE KEY UPDATE home_location = VALUES(home_location)
    """)
    override fun setClanHome(
        @Bind("OWNER") owner: ClanPlayer,
        @Bind("NAME") name: String,
        @Bind("LOCATION") location: Location?
    )

}
