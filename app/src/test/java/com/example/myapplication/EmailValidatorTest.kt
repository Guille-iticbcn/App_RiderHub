package com.example.myapplication
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EmailValidatorTest {
    private lateinit var emailValidator: EmailValidator

    @Before
    fun setup() {
        emailValidator = EmailValidator()
    }

    @Test
    fun `test valid email`() {
        assertTrue(emailValidator.validateEmail("test@example.com"))
    }

    @Test
    fun `test email contains "@"`() {
        assertTrue(emailValidator.validateEmail("test@example.com"))
        assertFalse(emailValidator.validateEmail("testexample.com"))
    }

    @Test
    fun `test email contains domain ("dot")`() {
        assertTrue(emailValidator.validateEmail("test@example.com"))
        assertFalse(emailValidator.validateEmail("test@com"))
    }

    @Test
    fun `test email does not contain special characters`() {
        assertTrue(emailValidator.validateEmail("test@example.com"))
        assertFalse(emailValidator.validateEmail("test@exam!ple.com"))
    }

    @Test
    fun `test email does not contain spaces`() {
        assertTrue(emailValidator.validateEmail("test@example.com"))
        assertFalse(emailValidator.validateEmail("test @example.com"))
    }

    @Test
    fun `test email length does not exceed 320 characters`() {
        val validEmail = "a".repeat(300) + "@example.com"
        val invalidEmail = "a".repeat(321) + "@example.com"
        assertTrue(emailValidator.validateEmail(validEmail))
        assertFalse(emailValidator.validateEmail(invalidEmail))
    }

    @Test
    fun `test email is not empty`() {
        assertTrue(emailValidator.validateEmail("test@example.com"))
        assertFalse(emailValidator.validateEmail(""))
    }
}