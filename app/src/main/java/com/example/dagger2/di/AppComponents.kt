package com.example.dagger2.di

import android.content.Context
import com.example.dagger2.login.LoginComponent
import com.example.registration.RegistrationComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    //  Чтобы RegistrationActivity создавала экземпляры RegistrationComponent(субкомпонента),
    //  нам нужно выставить его Factory в интерфейсе AppComponent
    //  Expose RegistrationComponent factory from the graph

    // Types that can be retrieved from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    fun userManager(): com.example.usage.UserManager

//    // Classes that can be injected by this Component
//    fun inject(activity: MainActivity)
//    fun inject(activity: SettingsActivity)


//    В AppComponent мы должны удалить методы, которые могут внедрять классы представления регистрации,
//    потому что они больше не будут использоваться, эти классы будут использовать RegistrationComponent.

//    fun inject(activity: RegistrationActivity)
//    fun inject(fragment: EnterDetailsFragment)
//    fun inject(fragment: TermsAndConditionsFragment)
}