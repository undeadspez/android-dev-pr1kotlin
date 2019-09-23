package ua.nure.liubchenko.pr1.utils

interface ColorUtils {

    fun decomposeColor(color: Int): List<Int>

    fun composeColor(alpha: Int, red: Int, green: Int, blue: Int): Int
}

object ColorUtilsImpl : ColorUtils {

    override fun decomposeColor(color: Int): List<Int> {
        return listOf(
            color shr 24 and 0xff,
            color shr 16 and 0xff,
            color shr 8  and 0xff,
            color        and 0xff
        )
    }

    override fun composeColor(alpha: Int, red: Int, green: Int, blue: Int): Int {
        return listOf(
            alpha and 0xff shl 24,
            red   and 0xff shl 16,
            green and 0xff shl 8,
            blue  and 0xff
        ).reduce(Int::plus)
    }
}
