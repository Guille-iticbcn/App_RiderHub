package com.example.myapplication.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Usuario

class RecyclerViewHolder (view: View):RecyclerView.ViewHolder(view) {

    val user = view.findViewById<TextView>(R.id.tvUser)
    val username = view.findViewById<TextView>(R.id.tvUsername)
    val photo = view.findViewById<ImageView>(R.id.ivUser)

    fun render(userModel: Usuario){
        user.text = userModel.name
        username.text = userModel.username
    }
}