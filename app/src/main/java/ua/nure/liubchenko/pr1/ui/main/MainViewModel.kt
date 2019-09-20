package ua.nure.liubchenko.pr1.ui.main

import android.graphics.Color.*
import androidx.lifecycle.*
import ua.nure.liubchenko.pr1.utils.ColorUtils
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl

class MainViewModel : ViewModel(), ColorUtils by ColorUtilsImpl {

    companion object {
        val defaultColor: Int = parseColor("#ffa500")
    }

//    TODO: Doesn't work correctly
//    val color: LiveData<Int> by lazy {
//        MediatorLiveData<Int>().apply {
//            value = 0xff shl 24
//
//            addSource(redComponent) { r ->
//                this.apply { value = value!! or (r and 0xff shl 16) }
//            }
//
//            addSource(greenComponent) { g ->
//                this.apply { value = value!! or (g and 0xff shl 8) }
//            }
//
//            addSource(blueComponent)  { b ->
//                this.apply { value = value!! or (b and 0xff) }
//            }
//        }
//    }

    //val hexColor: LiveData<String> = Transformations.map(color, this::rgbColorToHexString)

    val redComponent: MutableLiveData<Int>   = MutableLiveData(red(defaultColor))

    val greenComponent: MutableLiveData<Int> = MutableLiveData(green(defaultColor))

    val blueComponent: MutableLiveData<Int>  = MutableLiveData(blue(defaultColor))

}
