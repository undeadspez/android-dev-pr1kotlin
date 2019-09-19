package ua.nure.liubchenko.pr1

import org.junit.Test
import org.junit.Assert.*
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl.rgbColorToHexString

class ColorUtilsUnitTest {

    @Test fun conversionFromHex_isCorrect() {
        val crimson = 0xdc143c
        val crimsonHexString = rgbColorToHexString(crimson)

        assertEquals("#dc143c", crimsonHexString)
    }

    @Test fun conversionFromDec_isCorrect() {
        val aquamarine = 8388564
        val aquamarineHexString = rgbColorToHexString(aquamarine)

        assertEquals("#7fffd4", aquamarineHexString)
    }

}
