package com.iamkamrul.ui.extension

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun<viewHolder,T: RecyclerView.Adapter<viewHolder>> Context.setUpGridRecyclerViewAdapter(
    view: RecyclerView,
    viewAdapter:T,
    columnCount:Int
){
    view.layoutManager = GridLayoutManager(this,columnCount)
    view.adapter = viewAdapter
}


fun<viewHolder,T:RecyclerView.Adapter<viewHolder>> Context.setUpVerticalRecyclerViewAdapter(
    view: RecyclerView,
    viewAdapter:T
){
    view.layoutManager = LinearLayoutManager(this)
    view.adapter = viewAdapter
}

