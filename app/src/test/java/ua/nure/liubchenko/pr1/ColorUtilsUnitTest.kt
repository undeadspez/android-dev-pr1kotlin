package ua.nure.liubchenko.pr1

import android.graphics.Color
import org.junit.Test
import org.junit.Assert.*
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl.colorToHexString

// TODO - Fix java.lang.RuntimeException: Method rgb in android.graphics.Color not mocked
class ColorUtilsUnitTest {
    @Test
    fun conversion_isCorrect() {
        val crimson = Color.rgb(0xdc, 0x14 ,0x3c)
        val hexString = colorToHexString(crimson)

        assertEquals("#dc143c", hexString)
    }
}
