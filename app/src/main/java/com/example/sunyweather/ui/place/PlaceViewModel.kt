package com.example.sunyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunyweather.logic.Repository
import com.example.sunyweather.logic.model.Place
import retrofit2.http.Query

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()


    val placeData = Transformations.switchMap(searchLiveData){query->
        Repository.searchPlaces(query)


    }
    fun searchPlace(query: String){
        searchLiveData.value=query
    }


}