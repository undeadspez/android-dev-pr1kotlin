package ua.nure.liubchenko.pr1.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ua.nure.liubchenko.pr1.R

class LandscapeFragment : Fragment() {

    companion object {
        fun newInstance() = LandscapeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_landscape, container, false)
    }

}
