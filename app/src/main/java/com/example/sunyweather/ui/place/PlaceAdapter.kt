package com.example.sunyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sunyweather.R
import com.example.sunyweather.logic.model.Place
/*
* PlaceAdapter适配器
* 并将泛型指定为PlaceAdapter.ViewHolder
* */
class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Place>):RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val  placeName:TextView = view.findViewById(R.id.placeName)
        val placeAddress:TextView = view.findViewById(R.id.palceAddress)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
        val  place = placeList[position]
        holder.placeName.text= place.name
        holder.placeAddress.text=place.address
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return placeList.size
    }

}