package ua.nure.liubchenko.pr1.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SeekBar

import ua.nure.liubchenko.pr1.R
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val model: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val orientation = arguments?.getInt("orientation")

        val layoutId = when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> R.layout.fragment_main_portrait
            Configuration.ORIENTATION_LANDSCAPE -> R.layout.fragment_main_landscape
            else -> R.layout.fragment_main_portrait
        }

        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpColorPanel()

        setUpSliderPanel()
    }

    private fun setUpColorPanel() {
        model.color.observe(viewLifecycleOwner, Observer { color ->
            view!!.findViewById<LinearLayout>(R.id.colorPanel).apply {
                setBackgroundColor(color)
            }
        })

        model.hexColor.observe(viewLifecycleOwner, Observer { hexColor ->
            view!!.findViewById<TextView>(R.id.colorLabel).apply {
                text = hexColor
            }
        })
    }

    private fun setUpSliderPanel() {
        model.redComponent.observe(viewLifecycleOwner, Observer { redComponent ->
            view!!.findViewById<TextView>(R.id.labelRed).apply {
                text = redComponent.toString()
            }
            view!!.findViewById<SeekBar>(R.id.sliderRed).apply {
                progress = redComponent
            }
        })

        model.greenComponent.observe(viewLifecycleOwner, Observer { greenComponent ->
            view!!.findViewById<TextView>(R.id.labelGreen).apply {
                text = greenComponent.toString()
            }
            view!!.findViewById<SeekBar>(R.id.sliderGreen).apply {
                progress = greenComponent
            }
        })

        model.blueComponent.observe(viewLifecycleOwner, Observer { blueComponent ->
            view!!.findViewById<TextView>(R.id.labelBlue).apply {
                text = blueComponent.toString()
            }
        })
    }

}
