package com.example.sunyweather.logic.network

import retrofit2.Call

import com.example.sunyweather.SunnyWeatherApplication
import com.example.sunyweather.logic.model.Place
import com.example.sunyweather.logic.model.PlcaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPhlaces(@Query("query") query: String): Call<PlcaceResponse>
}