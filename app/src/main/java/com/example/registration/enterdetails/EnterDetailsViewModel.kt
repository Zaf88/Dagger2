package com.example.registration.enterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

/**
 * EnterDetailsViewModel is the ViewModel that [EnterDetailsFragment] uses to
 * obtain to validate user's input data.
 */
private const val MAX_LENGTH = 5
class EnterDetailsViewModel @Inject constructor() {

    private val _enterDetailsState = MutableLiveData<EnterDetailsViewState>()
    val enterDetailsState: LiveData<EnterDetailsViewState>
        get() = _enterDetailsState

    fun validateInput(username: String, password: String) {
        when {
            username.length < MAX_LENGTH -> _enterDetailsState.value =
                EnterDetailsError("Username has to be longer than 4 characters")
            password.length < MAX_LENGTH -> _enterDetailsState.value =
                EnterDetailsError("Password has to be longer than 4 characters")
            else -> _enterDetailsState.value = EnterDetailsSuccess
        }
    }
}
