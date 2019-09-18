package ua.nure.liubchenko.pr1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import ua.nure.liubchenko.pr1.R

class LandscapeFragment : Fragment() {

    companion object {
        fun newInstance() = LandscapeFragment()
    }

    private lateinit var model: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_landscape, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = activity!!.let { ViewModelProviders.of(it).get(MyViewModel::class.java) }

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
            view!!.findViewById<SeekBar>(R.id.sliderBlue).apply {
                progress = blueComponent
            }
        })
    }

}
