package com.example.sunyweather.logic



import androidx.lifecycle.liveData
import com.example.sunyweather.logic.model.Place
import com.example.sunyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO


import okhttp3.Dispatcher
import java.lang.Exception
import java.util.concurrent.Executor
import kotlin.coroutines.CoroutineContext


object Repository {
    fun searchPlaces(query: String) = liveData<String>(Dispatchers.IO){
        var result = try {
            val plcaceResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (plcaceResponse.static == "ok") {
                val place = plcaceResponse.place
                Result.success(place)

            } else {
                Result.failure(RuntimeException("respons status is )${plcaceResponse.static}"))

            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)

        }
    }
}