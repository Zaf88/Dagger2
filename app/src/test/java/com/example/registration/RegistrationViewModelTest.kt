package com.example.registration

import com.example.usage.UserManager
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class RegistrationViewModelTest {

    private lateinit var userManager: UserManager
    private lateinit var viewModel: RegistrationViewModel

    @Before
    fun setup() {
        userManager = Mockito.mock(UserManager::class.java)
        viewModel = RegistrationViewModel(userManager)
    }

    @Test
    fun `Register user calls userManager`() {
        viewModel.updateUserData("username", "password")
        viewModel.acceptTCs()
        viewModel.registerUser()

        Mockito.verify(userManager).registerUser("username", "password")
    }
}
