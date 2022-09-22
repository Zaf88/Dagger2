package com.example.main

import com.example.dagger2.MainViewModel
import com.example.usage.UserDataRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MainViewModelTest {

    private lateinit var userDataRepository: UserDataRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        userDataRepository = Mockito.mock(UserDataRepository::class.java)
        viewModel = MainViewModel(userDataRepository)
    }

    @Test
    fun `Welcome text returns right text`() {
        Mockito.`when`(userDataRepository.username).thenReturn("username")

        Assert.assertEquals("Hello username!", viewModel.welcomeText)
    }

    @Test
    fun `Notifications text returns right text`() {
        Mockito.`when`(userDataRepository.unreadNotifications).thenReturn(5)

        Assert.assertEquals("You have 5 unread notifications", viewModel.notificationsText)
    }
}
