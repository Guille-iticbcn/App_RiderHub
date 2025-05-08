package com.example.myapplication

import android.widget.Toast
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class RegisterActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(RegisterActivity::class.java)

    private lateinit var registerActivityViewModel: RegisterActivityViewModel

    @Mock
    lateinit var errorNomUsuariObserver: Observer<String>

    @Mock
    lateinit var formularivalidObserver: Observer<Boolean>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        registerActivityViewModel = RegisterActivityViewModel()
        registerActivityViewModel.errorNomUsuari.observeForever(errorNomUsuariObserver)
        registerActivityViewModel.formularivalid.observeForever(formularivalidObserver)
    }

    @Test
    fun testRegisterUserWithValidData() {
        onView(withId(R.id.emailFieldSignUp))
            .perform(typeText("valid@example.com"), closeSoftKeyboard())

        onView(withId(R.id.passwordFieldSignUp))
            .perform(typeText("123456"), closeSoftKeyboard())

        onView(withId(R.id.passwordFieldSignUp2))
            .perform(typeText("123456"), closeSoftKeyboard())

        onView(withId(R.id.btnRegister)).perform(click())

        Mockito.verify(formularivalidObserver).onChanged(true)
    }

    @Test
    fun testRegisterUserWithInvalidEmail() {
        onView(withId(R.id.emailFieldSignUp))
            .perform(typeText("invalidemail"), closeSoftKeyboard())

        onView(withId(R.id.btnRegister)).perform(click())

        Mockito.verify(errorNomUsuariObserver).onChanged("Correu electrònic invàlid")
    }

    @Test
    fun testRegisterUserWithMismatchedPasswords() {
        onView(withId(R.id.emailFieldSignUp))
            .perform(typeText("valid@example.com"), closeSoftKeyboard())

        onView(withId(R.id.passwordFieldSignUp))
            .perform(typeText("123456"), closeSoftKeyboard())

        onView(withId(R.id.passwordFieldSignUp2))
            .perform(typeText("654321"), closeSoftKeyboard())

        onView(withId(R.id.btnRegister)).perform(click())

        Mockito.verify(errorNomUsuariObserver).onChanged("Les contrasenyes no coincideixen")
    }
}
