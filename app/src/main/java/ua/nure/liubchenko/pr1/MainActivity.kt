package ua.nure.liubchenko.pr1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ua.nure.liubchenko.pr1.ui.LandscapeFragment
import ua.nure.liubchenko.pr1.ui.PortraitFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val fragment = when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> PortraitFragment.newInstance()
            Configuration.ORIENTATION_LANDSCAPE -> LandscapeFragment.newInstance()
            else -> PortraitFragment.newInstance()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }
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
