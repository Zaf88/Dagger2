package com.example.registration.enterdetails

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.storage.LiveDataTestUtil
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EnterDetailsViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: EnterDetailsViewModel

    @Before
    fun setup() {
        viewModel = EnterDetailsViewModel()
    }

    @Test
    fun `ValidateInput gives error when username is invalid`() {
        viewModel.validateInput("user", "password")

        Assert.assertTrue(LiveDataTestUtil.getValue(viewModel.enterDetailsState) is EnterDetailsError)
    }

    @Test
    fun `ValidateInput gives error when password is invalid`() {
        viewModel.validateInput("username", "pass")

        Assert.assertTrue(LiveDataTestUtil.getValue(viewModel.enterDetailsState) is EnterDetailsError)
    }

    @Test
    fun `ValidateInput succeeds when input is valid`() {
        viewModel.validateInput("username", "password")

        Assert.assertTrue(LiveDataTestUtil.getValue(viewModel.enterDetailsState) is EnterDetailsSuccess)
    }
}