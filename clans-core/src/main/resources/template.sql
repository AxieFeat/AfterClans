CREATE TABLE IF NOT EXISTS `clans` (
    `clan_owner_uuid` BLOB NOT NULL,
    `name` TEXT NOT NULL,
    `stripped_name` TEXT NOT NULL,
    `balance` BIGINT NOT NULL DEFAULT 0,
    `exp` BIGINT NOT NULL DEFAULT 0,
    `clan_settings` TEXT NOT NULL DEFAULT '{}',
    PRIMARY KEY (`clan_owner_uuid`)
);

CREATE TABLE IF NOT EXISTS `clan_members` (
    `member_uuid` BLOB NOT NULL,
    `member_name` TEXT NOT NULL,
    `clan_owner_uuid` BLOB NOT NULL,
    `member_settings` TEXT NOT NULL DEFAULT '{}',
    PRIMARY KEY (`member_uuid`),
    FOREIGN KEY (`clan_owner_uuid`) REFERENCES `clans`(`clan_owner_uuid`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `clan_inventory` (
    `clan_owner_uuid` BLOB NOT NULL,
    `slot` INTEGER NOT NULL,
    `item` TEXT,
    PRIMARY KEY (`clan_owner_uuid`, `slot`),
    FOREIGN KEY (`clan_owner_uuid`) REFERENCES `clans`(`clan_owner_uuid`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `clan_homes` (
    `clan_owner_uuid` BLOB NOT NULL,
    `home_name` TEXT NOT NULL,
    `home_location` TEXT NOT NULL,
    PRIMARY KEY (`clan_owner_uuid`, `home_name`),
    FOREIGN KEY (`clan_owner_uuid`) REFERENCES `clans`(`clan_owner_uuid`) ON DELETE CASCADE
);
