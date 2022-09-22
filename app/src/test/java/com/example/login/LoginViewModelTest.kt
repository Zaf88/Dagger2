package com.example.login

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dagger2.login.LoginError
import com.example.dagger2.login.LoginSuccess
import com.example.dagger2.login.LoginViewModel
import com.example.storage.LiveDataTestUtil
import com.example.usage.UserManager
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class LoginViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel
    private lateinit var userManager: UserManager

    @Before
    fun setup() {
        userManager = Mockito.mock(UserManager::class.java)
        viewModel = LoginViewModel(userManager)
    }

    @Test
    fun `Get username`() {
        Mockito.`when`(userManager.username).thenReturn("Username")

        val username = viewModel.getUsername()

        Assert.assertEquals("Username", username)
    }

    @Test
    fun `Login emits success`() {
        Mockito.`when`(
            userManager.loginUser(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(true)

        viewModel.login("username", "login")

        assertEquals(LiveDataTestUtil.getValue(viewModel.loginState), LoginSuccess)
    }

    @Test
    fun `Login emits error`() {
        Mockito.`when`(
            userManager.loginUser(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
            )
        ).thenReturn(false)

        viewModel.login("username", "login")

        assertEquals(LiveDataTestUtil.getValue(viewModel.loginState), LoginError)
    }

    @Test
    fun `Login unregisters`() {
        viewModel.unregister()

        Mockito.verify(userManager).unregister()
    }
}
