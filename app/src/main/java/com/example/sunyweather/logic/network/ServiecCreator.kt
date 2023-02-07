package com.example.sunyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*
* Retofit构建器
* */

object ServiecCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/v2.6"
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun <T> create(serviceClass: Class<T>):T = retrofit.create(serviceClass)

    inline fun <reified T> create():T = create(T::class.java)

}