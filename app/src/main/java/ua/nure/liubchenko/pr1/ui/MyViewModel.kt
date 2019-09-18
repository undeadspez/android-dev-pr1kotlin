package ua.nure.liubchenko.pr1.ui

import android.graphics.Color.*
import androidx.lifecycle.*
import ua.nure.liubchenko.pr1.utils.ColorUtils
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl

class MyViewModel : ViewModel(), ColorUtils by ColorUtilsImpl {

    companion object {
        val defaultColor: Int = parseColor("#ffa500")
    }

    val color: LiveData<Int> by lazy {
        MediatorLiveData<Int>().apply {
            value = 0xff shl 24

            addSource(redComponent) { r ->
                this.apply { value = value!! or (r and 0xff shl 16) }
            }

            addSource(greenComponent) { g ->
                this.apply { value = value!! or (g and 0xff shl 8) }
            }

            addSource(blueComponent)  { b ->
                this.apply { value = value!! or (b and 0xff) }
            }
        }
    }

    val hexColor: LiveData<String> by lazy {
        Transformations.map(color, this::colorToHexString)
    }

    val redComponent: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(red(defaultColor))
    }

    val greenComponent: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(green(defaultColor))
    }

    val blueComponent: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(blue(defaultColor))
    }

}
