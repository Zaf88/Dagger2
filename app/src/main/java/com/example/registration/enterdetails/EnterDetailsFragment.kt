package com.example.registration.enterdetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.dagger2.R
import com.example.registration.RegistrationActivity
import com.example.registration.RegistrationViewModel
import java.time.temporal.TemporalAdjusters.next
import javax.inject.Inject

class EnterDetailsFragment : Fragment() {

    /**
     * RegistrationViewModel is used to set the username and password information (attached to
     * Activity's lifecycle and shared between different fragments)
     * EnterDetailsViewModel is used to validate the user input (attached to this
     * Fragment's lifecycle)
     *
     * They could get combined but for the sake of the codelab, we're separating them so we have
     * different ViewModels with different lifecycles.
     */
//    private lateinit var registrationViewModel: RegistrationViewModel
//    private lateinit var enterDetailsViewModel: EnterDetailsViewModel

//    Для фрагментов мы внедряем компоненты (AppComponents с помощью метода onAttach после вызова super.onAttach.
    override fun onAttach(context: Context) {
        super.onAttach(context)

//      заменяем , так как использует субкомпонент
//      (requireActivity().application as MyApplication).appComponent.inject(this)
        (activity as RegistrationActivity).registrationComponent.inject(this)
    }



    @Inject
    lateinit var registrationViewModel: RegistrationViewModel
    @Inject
    lateinit var enterDetailsViewModel: EnterDetailsViewModel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_enter_details, container, false)

//        registrationViewModel = (activity as RegistrationActivity).registrationViewModel
//        enterDetailsViewModel = EnterDetailsViewModel()

        enterDetailsViewModel.enterDetailsState.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is EnterDetailsSuccess -> {

                        val username = usernameEditText.text.toString()
                        val password = passwordEditText.text.toString()
                        registrationViewModel.updateUserData(username, password)

                        (activity as RegistrationActivity).onDetailsEntered()
                    }
                    is EnterDetailsError -> {
                        errorTextView.text = state.error
                        errorTextView.visibility = View.VISIBLE
                    }
                }
            }
        )

        setupViews(view)
        return view
    }

    private fun setupViews(view: View) {
        errorTextView = view.findViewById(R.id.error)

        usernameEditText = view.findViewById(R.id.username)
        usernameEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        passwordEditText = view.findViewById(R.id.password)
        passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            enterDetailsViewModel.validateInput(username, password)
        }
    }
}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()
