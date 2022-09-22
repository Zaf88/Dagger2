package com.example.di

import com.example.dagger2.di.AppComponent
import com.example.dagger2.di.AppSubcomponents
import dagger.Component
import javax.inject.Singleton

@Singleton
// Includes TestStorageModule that overrides objects provided in StorageModule
@Component(modules = [TestStorageModule::class, AppSubcomponents::class])
interface TestAppComponent : AppComponent
