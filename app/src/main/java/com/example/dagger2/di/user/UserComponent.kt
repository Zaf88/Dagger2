package com.example.dagger2.di.user

import com.example.dagger2.MainActivity
import com.example.settings.SettingsActivity
import dagger.Subcomponent

@LoggedUserScope


@Subcomponent
interface UserComponent {


    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: SettingsActivity)
}