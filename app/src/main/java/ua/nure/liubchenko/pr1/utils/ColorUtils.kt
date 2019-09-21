package ua.nure.liubchenko.pr1.utils

import java.util.*

interface ColorUtils {
    fun rgbColorToHexString(color: Int): String
}

object ColorUtilsImpl : ColorUtils {

    override fun rgbColorToHexString(color: Int): String = color.let {
        arrayOf(
            it shr 16 and 0xff,
            it shr 8 and 0xff,
            it and 0xff
        ).map { component ->
            component
                .toString(16)
                .toLowerCase(Locale.getDefault())
                .padStart(2, '0')
        }.fold("#", String::plus)
    }

}
