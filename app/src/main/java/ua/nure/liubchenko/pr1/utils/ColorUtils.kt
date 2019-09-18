package ua.nure.liubchenko.pr1.utils

import android.graphics.Color
import java.util.*

interface ColorUtils {
    fun colorToHexString(color: Int): String
}

object ColorUtilsImpl : ColorUtils {

    override fun colorToHexString(color: Int): String = color.let {
        arrayOf(
            Color.red(it),
            Color.green(it),
            Color.blue(it)
        ).map { component ->
            component
                .toString(16)
                .toLowerCase(Locale.getDefault())
                .padStart(2, '0')
        }.fold("#", String::plus)
    }

}