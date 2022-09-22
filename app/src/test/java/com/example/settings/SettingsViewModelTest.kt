package com.example.settings

import com.example.usage.UserDataRepository
import com.example.usage.UserManager
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SettingsViewModelTest {

    private lateinit var userManager: UserManager
    private lateinit var userDataRepository: UserDataRepository
    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setup() {
        userManager = Mockito.mock(UserManager::class.java)
        userDataRepository = Mockito.mock(UserDataRepository::class.java)
        viewModel = SettingsViewModel(userDataRepository, userManager)
    }

    @Test
    fun `Refresh notifications works as expected`() {
        viewModel.refreshNotifications()

        Mockito.verify(userDataRepository).refreshUnreadNotifications()
    }

    @Test
    fun `Logout works as expected`() {
        viewModel.logout()

        Mockito.verify(userManager).logout()
    }
}
