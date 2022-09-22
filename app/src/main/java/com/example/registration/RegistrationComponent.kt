package com.example.registration

import com.example.dagger2.di.ActivityScope
import com.example.registration.enterdetails.EnterDetailsFragment
import com.example.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

//    В AppComponent мы должны удалить методы, которые могут внедрять классы представления регистрации,
//    потому что они больше не будут использоваться, эти классы будут использовать RegistrationComponent.
//    Вместо этого, чтобы RegistrationActivity создавала экземпляры RegistrationComponent,
//    нам нужно выставить его Factory в интерфейсе AppComponent.

    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}

