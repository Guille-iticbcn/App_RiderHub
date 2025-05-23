package com.example.myapplication
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PasswordValidatorTest {
    private lateinit var passwordValidator: PasswordValidator

    @Test
    fun `test valid password`() {
        val password = "Password1!"
        val confirmPassword = "Password1!"
        assertEquals("Contraseña válida", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password is null`() {
        val password = null
        val confirmPassword = "Password1!"
        assertEquals("La contraseña no puede ser nula.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test passwords do not match`() {
        val password = "Password1!"
        val confirmPassword = "password1!"
        assertEquals("Las contraseñas no coinciden.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password length less than 8 characters`() {
        val password = "Pass1!"
        val confirmPassword = "Pass1!"
        assertEquals("La contraseña debe tener entre 8 y 12 caracteres.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password length more than 12 characters`() {
        val password = "Password123456!"
        val confirmPassword = "Password123456!"
        assertEquals("La contraseña debe tener entre 8 y 12 caracteres.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password does not contain uppercase letter`() {
        val password = "password1!"
        val confirmPassword = "password1!"
        assertEquals("La contraseña debe contener al menos una letra mayúscula.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password does not contain number`() {
        val password = "Password!"
        val confirmPassword = "Password!"
        assertEquals("La contraseña debe contener al menos un número.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password does not contain special character`() {
        val password = "Password123"
        val confirmPassword = "Password123"
        assertEquals("La contraseña debe contener al menos un carácter especial.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password contains spaces`() {
        val password = "Password 1!"
        val confirmPassword = "Password 1!"
        assertEquals("La contraseña no puede contener espacios.", passwordValidator.validatePassword(password, confirmPassword))
    }

    @Test
    fun `test password contains invalid special character`() {
        val password = "Password1?¿"
        val confirmPassword = "Password1?¿"
        assertEquals("La contraseña contiene caracteres especiales no permitidos.", passwordValidator.validatePassword(password, confirmPassword))
    }
}