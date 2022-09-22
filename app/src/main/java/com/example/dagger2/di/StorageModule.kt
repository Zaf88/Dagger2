package com.example.dagger2.di

import com.example.storage.SharedPreferencesStorage
import com.example.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}