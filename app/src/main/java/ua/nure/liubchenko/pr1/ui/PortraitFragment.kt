package ua.nure.liubchenko.pr1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import ua.nure.liubchenko.pr1.R
import android.widget.TextView

class PortraitFragment : Fragment() {

    companion object {
        fun newInstance() = PortraitFragment()
    }

    private lateinit var model: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_portrait, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model = activity?.let { ViewModelProviders.of(it)[MyViewModel::class.java] }!!

        view.findViewById<TextView>(R.id.colorLabel).apply {
            text = model.toString()
        }
    }

}
