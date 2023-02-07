package com.example.sunyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunyWeatherApplication : Application() {
    companion object{

        const val TOKEN = "HZRgYneU39yTuYMy"
        @SuppressLint
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}