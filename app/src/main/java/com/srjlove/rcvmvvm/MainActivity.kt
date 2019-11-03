package com.srjlove.rcvmvvm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.srjlove.rcvmvvm.helper.ThemeHelper
import com.srjlove.rcvmvvm.repository.MovieRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    val preferenceRepository by lazy {
        (application as App).preferenceRepository

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repo = MovieRepository(IMoviesApi())

        GlobalScope.launch(Main) {
            val movieList = repo.getMovies()

            Toast.makeText(this@MainActivity, movieList.toString(), Toast.LENGTH_LONG).show()

        }


        println("Dark THEME: ${preferenceRepository.isDarkTheme}")

        btn_light.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.darkMode)
            preferenceRepository.isDarkTheme = false
            restartAppWithMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        btn_dark.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.darkMode)
            preferenceRepository.isDarkTheme = true
            restartAppWithMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        btn_battery.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.batterySaverMode)
            restartAppWithMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
        }
        btn_default.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.default)
            restartAppWithMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        /*preferenceRepository.isDarkThemeLive.observe(this, Observer { isDarkTheme ->
            isDarkTheme?.let {
                println(it)
            }
        })*/

        /*  preferenceRepository.isDarkThemeLive.observe(this, Observer { isDarkTheme ->
              isDarkTheme?.let {
                  System.out.println(it)
              }
          })

          (application as App).preferenceRepository.nightModeLive
              .observe(this, Observer { nightMode ->
                  nightMode?.let {
                      delegate.localNightMode = it
                  }
              })*/


    }

    private fun restartAppWithMode(mode: Int) {

        AppCompatDelegate.setDefaultNightMode(mode)
        startActivity(Intent(this@MainActivity, MainActivity::class.java))
        finish()
    }
}
