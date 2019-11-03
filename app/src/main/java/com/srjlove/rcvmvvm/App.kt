package com.srjlove.rcvmvvm

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import com.srjlove.rcvmvvm.repository.PreferenceRepository

class App : Application() {

    companion object {
        const val DEFAULT_PREFERENCES = "theme_preferences"
    }
    lateinit var preferenceRepository: PreferenceRepository


    override fun onCreate() {
        super.onCreate()

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)


        preferenceRepository = PreferenceRepository(
            getSharedPreferences(DEFAULT_PREFERENCES, Context.MODE_PRIVATE)
        )

    }
}