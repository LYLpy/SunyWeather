package com.example.sunyweather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class PlcaceResponse(val static:String,val place:List<Place>)

data class Place(var name: String,var location:Locale,@SerializedName("formatted_address")var address:String)

data class Location(val lng:String,val lat:String)