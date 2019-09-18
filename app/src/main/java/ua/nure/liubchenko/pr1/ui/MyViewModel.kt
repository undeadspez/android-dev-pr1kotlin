package ua.nure.liubchenko.pr1.ui

import android.graphics.Color.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ua.nure.liubchenko.pr1.utils.ColorUtils
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl

class MyViewModel : ViewModel(), ColorUtils by ColorUtilsImpl {

    val color: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(argb(0xff, 0xff, 0xa5,0x00))
    }

    val hexColor: LiveData<String> = Transformations.map(color) {
        colorToHexString(it)
    }
}
