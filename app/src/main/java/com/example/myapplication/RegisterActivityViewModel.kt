package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterActivityViewModel : ViewModel() {

    private var _nomUsuari: String = ""
    private var _email: String = ""
    private var _contrassenya: String = ""
    private var _confirmarContrassenya: String = ""

    private val _formularivalid = MutableLiveData<Boolean>(false)
    val formularivalid: LiveData<Boolean> = _formularivalid

    private val _errorNomUsuari = MutableLiveData<String>("")
    val errorNomUsuari: LiveData<String> = _errorNomUsuari

    private val _errorContrassenya = MutableLiveData<String>("")
    val errorContrassenya: LiveData<String> = _errorContrassenya

    private val _errorConfirmarContrassenya = MutableLiveData<String>("")
    val errorConfirmarContrassenya: LiveData<String> = _errorConfirmarContrassenya

    fun actualitzaEmail(email: String) {
        _email = email
    }

    fun actualitzaContrassenya(contrassenya: String) {
        _contrassenya = contrassenya
    }

    fun actualitzaConfirmarContrassenya(contrassenya: String) {
        _confirmarContrassenya = contrassenya
    }

    fun comprova_email() {
        if (_email.isEmpty()) {
            _errorNomUsuari.value = "El correu electrònic és obligatori"
        } else if (!_email.contains("@")) {
            _errorNomUsuari.value = "Correu electrònic invàlid"
        } else {
            _errorNomUsuari.value = ""
        }
    }

    fun comprova_contrassenya() {
        if (_contrassenya.isEmpty()) {
            _errorContrassenya.value = "La contrassenya és obligatòria"
        } else if (_contrassenya.length < 6) {
            _errorContrassenya.value = "La contrassenya ha de tenir almenys 6 caràcters"
        } else {
            _errorContrassenya.value = ""
        }
    }

    fun comprova_confirmarContrassenya() {
        if (_confirmarContrassenya.isEmpty()) {
            _errorConfirmarContrassenya.value = "La confirmació de la contrassenya és obligatòria"
        } else if (_confirmarContrassenya != _contrassenya) {
            _errorConfirmarContrassenya.value = "Les contrasenyes no coincideixen"
        } else {
            _errorConfirmarContrassenya.value = ""
        }
    }

    fun comprovadadesusuari() {
        comprova_email()
        comprova_contrassenya()
        comprova_confirmarContrassenya()

        _formularivalid.value = _errorNomUsuari.value.isNullOrEmpty() &&
                _errorContrassenya.value.isNullOrEmpty() &&
                _errorConfirmarContrassenya.value.isNullOrEmpty()
    }
}
