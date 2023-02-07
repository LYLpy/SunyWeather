package com.example.sunyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/*
* 一个统一的网络数据源访问入口
* 对所有的网络请求的API进行封装
* */
object SunnyWeatherNetwork {

    //动态接口代理对象
    private val placeService = ServiecCreator.create<PlaceService>()

    //使用协程将其挂起

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()
    /*
    * 当调用到searchPlaces（）函数时Rertorfit就会立刻发起网路请求，同时线程将会阻塞
    * 直到服务器响应请求之后，await（）函数将解析出来的数据模型对象取出同时回复当前协程的执行
    * searchPlaces()函数在得到await（）函数的返回值后将该数据再返回到上一层
    * */
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                            RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }


}