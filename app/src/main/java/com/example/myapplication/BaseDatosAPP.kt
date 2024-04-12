package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosAPP(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {

    val create_users_table = "CREATE TABLE Users" +
            "(ID INT PRIMARY KEY," +
            "USERNAME TEXT," +
            "USER_PASSWORD TEXT)"

    val insert = "INSERT INTO Users (ID, USERNAME, USER_PASSWORD) VALUES (1, 'Guille', '1234a')"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(create_users_table)
        db?.execSQL(insert)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}