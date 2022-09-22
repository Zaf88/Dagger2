package com.example.dagger2.di

import com.example.dagger2.di.user.UserComponent
import com.example.dagger2.login.LoginComponent
import com.example.registration.RegistrationComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubcomponents
