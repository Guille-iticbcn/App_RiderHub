package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val baseDatos = BaseDatosAPP(this, "db", null, 1)
        val db = baseDatos.writableDatabase
        initEvents()
    }

    fun initEvents(){
        val button = findViewById<Button>(R.id.button2)
        val buttonHome = findViewById<Button>(R.id.buttonHome)
        val buttonSearch = findViewById<Button>(R.id.buttonSearch)
        val buttonPhoto = findViewById<Button>(R.id.buttonPhoto)
        val buttonProfile = findViewById<Button>(R.id.buttonProfile)

        button.setOnClickListener({
            val i = Intent (this, MessageActivity::class.java)
            startActivity(i)
        })

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