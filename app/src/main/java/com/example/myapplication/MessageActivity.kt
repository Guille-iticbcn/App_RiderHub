package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.RecyclerViewAdapter

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messages)
        initRecyclerView()
        initEvents()
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(RecyclerViewProvider.user)
    }

    fun initEvents(){
        val buttonHome = findViewById<Button>(R.id.buttonHome)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val buttonPhoto = findViewById<Button>(R.id.buttonPhoto)
        val buttonProfile = findViewById<Button>(R.id.buttonProfile)

        buttonHome.setOnClickListener({
            val i = Intent (this, MainActivity::class.java)
            startActivity(i)
        })
        buttonSearch.setOnClickListener({
            val i = Intent (this, SearchActivity::class.java)
            startActivity(i)
        })
        buttonPhoto.setOnClickListener({
            val i = Intent (this, NewPublicationActivity::class.java)
            startActivity(i)
        })
        buttonProfile.setOnClickListener({
            val i = Intent (this, ProfileActivity::class.java)
            startActivity(i)
        })
    }
}