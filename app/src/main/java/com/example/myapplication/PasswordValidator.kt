package com.example.myapplication

class PasswordValidator {
    fun validatePassword(password: String?, confirmPassword: String?): String {
        if (password == null || confirmPassword == null) return "La contraseña no puede ser nula."
        if (password != confirmPassword) return "Las contraseñas no coinciden."
        if (password.length !in 8..12) return "La contraseña debe tener entre 8 y 12 caracteres."
        if (!password.any { it.isUpperCase() }) return "La contraseña debe contener al menos una letra mayúscula."
        if (!password.any { it.isDigit() }) return "La contraseña debe contener al menos un número."
        val specialChars = "!@#$%^&*()_-+=<>?¿"
        if (!password.any { it in specialChars }) return "La contraseña debe contener al menos un carácter especial."
        if (password.contains(" ")) return "La contraseña no puede contener espacios."
        val invalidSpecialChars = "?¿~"
        if (password.any { it in invalidSpecialChars }) return "La contraseña contiene caracteres especiales no permitidos."
        return "Contraseña válida"
    }
}