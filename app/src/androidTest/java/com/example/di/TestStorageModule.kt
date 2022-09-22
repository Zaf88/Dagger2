package com.example.di

import com.example.storage.Storage
import dagger.Binds
import dagger.Module
import javax.inject.Inject

@Module
abstract class TestStorageModule {

    // Makes Dagger provide FakeStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}


class FakeStorage @Inject constructor(): Storage {

    private val map = mutableMapOf<String, String>()

    override fun setString(key: String, value: String) {
        map[key] = value
    }

    override fun getString(key: String): String {
        return map[key].orEmpty()
    }
}
