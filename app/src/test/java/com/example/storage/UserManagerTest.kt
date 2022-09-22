package com.example.storage

import com.example.dagger2.di.user.UserComponent
import com.example.usage.UserManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class UserManagerTest {
    //    Например, если вы посмотрите на файл LoginViewModelTest.kt, который тестирует LoginViewModel,
//    мы просто имитируем UserManager и передаем его в качестве параметра, как мы бы сделали без Dagger.
    private lateinit var storage: Storage
    private lateinit var userManager: UserManager

    //    @Before
//
//    fun setup() {
//        storage = FakeStorage()
//        userManager = UserManager(storage)
//    }
//    Все модульные тесты остаются такими же, как и при ручном внедрении зависимостей,
    //    за исключением одного. Когда мы добавили UserComponent.Factory в UserManager,
    //    мы сломали его модульные тесты. Мы должны имитировать то, что вернет Dagger при
    //    вызове create() на фабрике.
    @Before
    fun setup() {
        // Return mock userComponent when calling the factory
        val userComponentFactory = Mockito.mock(UserComponent.Factory::class.java)
        val userComponent = Mockito.mock(UserComponent::class.java)
        Mockito.`when`(userComponentFactory.create()).thenReturn(userComponent)

        storage = FakeStorage()
        userManager = UserManager(storage, userComponentFactory)
    }
    @Test
    fun `Username returns what is in the storage`() {
        Assert.assertEquals("", userManager.username)

        userManager.registerUser("username", "password")

        Assert.assertEquals("username", userManager.username)
    }

    @Test
    fun `IsUserRegistered behaves as expected`() {
        Assert.assertFalse(userManager.isUserRegistered())

        userManager.registerUser("username", "password")

        Assert.assertTrue(userManager.isUserRegistered())
    }

    @Test
    fun `Register user adds username and password to the storage`() {
        Assert.assertFalse(userManager.isUserRegistered())
        Assert.assertFalse(userManager.isUserLoggedIn())

        userManager.registerUser("username", "password")

        Assert.assertTrue(userManager.isUserRegistered())
        Assert.assertTrue(userManager.isUserLoggedIn())
        Assert.assertEquals("username", storage.getString("registered_user"))
        Assert.assertEquals("password", storage.getString("usernamepassword"))
    }

    @Test
    fun `Login succeeds when username is registered and password is correct`() {
        userManager.registerUser("username", "password")
        userManager.logout()

        Assert.assertTrue(userManager.loginUser("username", "password"))
        Assert.assertTrue(userManager.isUserLoggedIn())
    }

    @Test
    fun `Login fails when username is not registered`() {
        userManager.registerUser("username", "password")
        userManager.logout()

        Assert.assertFalse(userManager.loginUser("username2", "password"))
        Assert.assertFalse(userManager.isUserLoggedIn())
    }

    @Test
    fun `Login fails when username is registered but password is incorrect`() {
        userManager.registerUser("username", "password")
        userManager.logout()

        Assert.assertFalse(userManager.loginUser("username", "password2"))
        Assert.assertFalse(userManager.isUserLoggedIn())
    }

    @Test
    fun `Unregister behaves as expected`() {
        userManager.registerUser("username", "password")
        Assert.assertTrue(userManager.isUserLoggedIn())

        userManager.unregister()
        Assert.assertFalse(userManager.isUserLoggedIn())
        Assert.assertFalse(userManager.isUserRegistered())
    }
}
