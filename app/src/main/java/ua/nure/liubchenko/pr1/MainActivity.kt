package ua.nure.liubchenko.pr1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ua.nure.liubchenko.pr1.ui.main.LandscapeFragment
import ua.nure.liubchenko.pr1.ui.main.MainFragment
import ua.nure.liubchenko.pr1.ui.main.PortraitFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> R.layout.fragment_portrait
            Configuration.ORIENTATION_LANDSCAPE -> R.layout.fragment_landscape
            else -> R.layout.fragment_portrait
        })

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.fragment_portrait)
        } else {
            setContentView(R.layout.fragment_landscape)
        }
    }

}
