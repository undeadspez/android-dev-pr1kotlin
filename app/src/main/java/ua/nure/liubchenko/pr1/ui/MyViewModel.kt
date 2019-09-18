package ua.nure.liubchenko.pr1.ui

import android.graphics.Color.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ua.nure.liubchenko.pr1.utils.ColorUtils
import ua.nure.liubchenko.pr1.utils.ColorUtilsImpl

class MyViewModel : ViewModel(), ColorUtils by ColorUtilsImpl {

    val colorData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(MAGENTA)
    }

    val hexColor: LiveData<String> = Transformations.map(colorData) {
        colorToHexString(it)
    }
}
