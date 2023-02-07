package com.example.sunyweather.logic

import androidx.lifecycle.liveData
import com.example.sunyweather.logic.model.Place
import com.example.sunyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers


/*
*仓库层的主要工作时是判断调用方请求数据应该是从本地数据源中获取还是从网络数据原中获取
* 这里直接从网络数据源获取
* Repository单例作为仓库的统一封装入口
* */
object Repository {
    fun searchPlase(query: String) = liveData(Dispatchers.IO) {
        var result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val place = placeResponse.places
                Result.success(place)
            } else {
                Result.failure(RuntimeException("response status is${placeResponse.status}"))
            }

        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}
//object Repository {
//
//    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
//        val result = try {
//            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
//            if (placeResponse.status == "ok") {
//                val places = placeResponse.places
//                Result.success(places)
//            } else {
//                Result.failure(RuntimeException("response status is${placeResponse.status}"))
//            }
//        } catch (e: Exception) {
//            Result.failure<List<Place>>(e)
//        }
//        emit(result)
//    }
//
//}
