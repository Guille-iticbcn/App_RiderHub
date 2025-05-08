package com.example.myapplication

class EmailValidator {
    fun validateEmail(email: String): Boolean {
        if (email.isEmpty()) return false
        if (email.length > 320) return false
        if (email.contains(" ")) return false
        if (!email.contains("@")) return false
        if (!email.contains(".")) return false
        if (!email.matches("^[a-zA-Z0-9@.]+$".toRegex())) return false
        return true
    }
}