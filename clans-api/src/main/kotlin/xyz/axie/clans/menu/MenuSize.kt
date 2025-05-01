package xyz.axie.clans.menu

/**
 * All available sizes of menu.
 *
 * @param slots Count of slots in this size.
 */
enum class MenuSize(
    val slots: Int,
) {

    ROWS_1(9),
    ROWS_2(18),
    ROWS_3(27),
    ROWS_4(36),
    ROWS_5(45),
    ROWS_6(54),

}