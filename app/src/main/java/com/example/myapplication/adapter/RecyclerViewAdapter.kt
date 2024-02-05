package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Usuario

class RecyclerViewAdapter (private val recyclerViewList: List<Usuario>): RecyclerView.Adapter<RecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount() : Int = recyclerViewList.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = recyclerViewList[position]
        holder.render(item)
    }
}