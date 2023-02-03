package com.example.sunyweather

import android.app.Application
import android.content.Context
import android.os.Parcelable

class SunnyWeatherApplication : Application() {
    companion object{
        const val TOKEN ="HZRgYneU39yTuYMy"

        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }
}