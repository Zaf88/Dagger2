package com.example.registration

import com.example.dagger2.di.ActivityScope
import com.example.registration.enterdetails.EnterDetailsFragment
import com.example.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {


    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }


    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}

