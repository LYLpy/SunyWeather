package com.example.sunyweather.logic.network

import com.example.sunyweather.SunyWeatherApplication
import com.example.sunyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/*
* 用于访问彩云城市搜索API的Retrofit接口
* */
interface PlaceService {
    @GET("v2/place?token=${SunyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>

}
