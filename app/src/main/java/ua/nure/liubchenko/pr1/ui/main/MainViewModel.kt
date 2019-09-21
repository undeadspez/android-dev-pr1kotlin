package ua.nure.liubchenko.pr1.ui.main

import android.graphics.Color.*
import androidx.lifecycle.*
import ua.nure.liubchenko.pr1.utils.ColorUtils
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl
import androidx.lifecycle.LiveData

class MainViewModel : ViewModel(), ColorUtils by ColorUtilsImpl {

    companion object {
        val defaultColor: Int = parseColor("#ffa500")
    }

    val textColor: LiveData<Int> by lazy {
        color.map {
            if (luminance(it) > 0.5) BLACK
            else WHITE
        }
    }

    /**
     * Previous implementation (wasn't working). TODO: Compare implementations.
     * val color: LiveData<Int> by lazy {
     *     MediatorLiveData<Int>().apply {
     *         value = 0xff shl 24
     *         addSource(redComponent)   { r -> value = value!! or (r and 0xff shl 16) }
     *         addSource(greenComponent) { g -> value = value!! or (g and 0xff shl 8) }
     *         addSource(blueComponent)  { b -> value = value!! or (b and 0xff) }
     *     }
     * }
     */
    val color: LiveData<Int> by lazy {
        redComponent.switchMap { r ->
            greenComponent.switchMap { g ->
                blueComponent.switchMap { b ->
                    arrayOf(
                              0xff shl 24,
                        r and 0xff shl 16,
                        g and 0xff shl 8,
                        b and 0xff
                    ).reduce(Int::plus).let { MutableLiveData(it) }
                }
            }
        }
    }

    val colorLabel: LiveData<String> by lazy {
        Transformations.map(color, this::rgbColorToHexString)
    }

    val redComponent: MutableLiveData<Int> by lazy {
        MutableLiveData(red(defaultColor))
    }

    val greenComponent: MutableLiveData<Int> by lazy {
        MutableLiveData(green(defaultColor))
    }

    val blueComponent: MutableLiveData<Int> by lazy {
        MutableLiveData(blue(defaultColor))
    }

}
