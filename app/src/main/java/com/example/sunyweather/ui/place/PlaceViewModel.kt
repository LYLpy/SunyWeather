package com.example.sunyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunyweather.logic.Repository
import com.example.sunyweather.logic.model.Place

/*
* 定义ViewModel层
* */
class PlaceViewModel:ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()
    //使用Transformations.switchMap()观察传入的对象
    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Repository.searchPlase(query)//接收数据
    }

    fun searchPlaces(query:String){
        searchLiveData.value= query
    }
}