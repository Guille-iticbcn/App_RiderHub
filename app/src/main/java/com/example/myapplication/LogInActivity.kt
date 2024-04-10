package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        initEvents()
    }

    private fun initEvents() {
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLogIn = findViewById<Button>(R.id.btnLogIn)

        btnRegister.setOnClickListener({
            val i = Intent (this, RegisterActivity::class.java)
            startActivity(i)
        })

        btnLogIn.setOnClickListener({
            val i = Intent (this, MainActivity::class.java)
            startActivity(i)
        })
    }

    fun iniciarSesion (view : View) {
        val email : EditText = findViewById(R.id.emailFieldSignUp)
        val etPass : EditText = findViewById(R.id.passwordFieldSignUp)

        if(email.text.toString() == "Guille"){
            if(etPass.text.toString() == "12345") {
                Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "Usuario o Contraseña incorrectos.", Toast.LENGTH_LONG).show()
        }

    }


}