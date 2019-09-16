package ua.nure.liubchenko.pr1.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ua.nure.liubchenko.pr1.R

class PortraitFragment : Fragment() {

    companion object {
        fun newInstance() = PortraitFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_portrait, container, false)
    }

}
