package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerActivityViewModel: RegisterActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register)
        registerActivityViewModel = ViewModelProvider(this).get(RegisterActivityViewModel::class.java)
        initEvents()

        registerActivityViewModel.errorNomUsuari.observe(this, { error ->
            val nameInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
            if (error.isNotEmpty()) {
                nameInputLayout.error = error
            } else {
                nameInputLayout.error = null
            }
        })

        registerActivityViewModel.formularivalid.observe(this, { isValid ->
            if (isValid) {
                // Si el formulario es válido, proceder con el registro (esto es solo un ejemplo)
                Toast.makeText(this, "Formulario válido. Registrando usuario...", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar mensaje si hay errores
                Toast.makeText(this, "Formulario inválido. Por favor revisa los campos.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Método para inicializar los eventos
    private fun initEvents() {
        val emailInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
        val passwordConfirmInputLayout = findViewById<TextInputLayout>(R.id.textInputLayoutPasswordConfirm)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val email = emailInputLayout.editText?.text.toString()
            val password = passwordInputLayout.editText?.text.toString()
            val confirmPassword = passwordConfirmInputLayout.editText?.text.toString()

            registerActivityViewModel.actualitzaEmail(email)
            registerActivityViewModel.actualitzaContrassenya(password)
            registerActivityViewModel.actualitzaContrassenya(confirmPassword)
            registerActivityViewModel.comprovadadesusuari()
        }
    }
}
