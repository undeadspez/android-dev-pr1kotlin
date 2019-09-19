package ua.nure.liubchenko.pr1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ua.nure.liubchenko.pr1.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val fragment = getFragment(orientation = resources.configuration.orientation)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        val fragment = getFragment(orientation = newConfig.orientation)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    private fun getFragment(orientation: Int): Fragment = orientation.let {
        MainFragment.newInstance().apply {
            arguments = Bundle().apply {
                putInt("orientation", it)
            }
        }
    }

}
