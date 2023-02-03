package com.example.sunyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import retrofit2.http.Query
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//网络数据访问入口

object SunnyWeatherNetwork {

    private var placeService = ServiceCreator.create(PlaceService::class.java)
    suspend fun searchPlaces(query: String) = placeService.searchPhlaces(query).await()

    private suspend fun <T> Call<T>.await(): T {

        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    TODO("Not yet implemented")
                    val body = response.body()
                    if (body != null) continuation.resume(body)

                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    TODO("Not yet implemented")
                    continuation.resumeWithException(t)
                }
            }
            )
        }

    }


}