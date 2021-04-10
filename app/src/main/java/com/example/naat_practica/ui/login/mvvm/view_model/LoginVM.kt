package com.example.naat_practica.ui.login.mvvm.view_model

import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.naat_practica.core.preferences.Preferences
import com.example.naat_practica.core.views.DialogError
import com.example.naat_practica.ui.login.data.interactors.LoginInteractor
import com.example.naat_practica.utils.validEmail
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginVM @Inject constructor(val loginInteractor: LoginInteractor, val preferences: Preferences) : ViewModel() {

    private val _user            = MutableLiveData<String>()
    private val _password        = MutableLiveData<String>()
    private val _token           = MutableLiveData<String>()
    private val _showProgressBar = MutableLiveData<Boolean>()

    val user           : LiveData<String>  get() = _user
    val password       : LiveData<String>  get() = _password
    val token          : LiveData<String>  get() = _token
    val showProgressBar: LiveData<Boolean> get()= _showProgressBar

    val validLogin: Boolean = user.value.validEmail() && !password.value.isNullOrEmpty()

    init {
        _token.value           = null
        _showProgressBar.value = false
    }

    fun afterUserTextChanged(editText: TextInputEditText) {
        val text = editText.text.toString()
        _user.value = text
    }

    fun afterPasswordTextChanged(editText: TextInputEditText) {
        val text = editText.text.toString()
        _password.value = text
    }

    fun login(fragmentManager: FragmentManager) {
        _showProgressBar.value = !showProgressBar.value!!
        loginInteractor.login(user.value, password.value)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                Log.d("login_debug", "RESPONSE: $response")
                _showProgressBar.value = !showProgressBar.value!!

                if (response.success != null && response.success!!) {
                    preferences.setToken(response.access_token)
                    _token.value = response.access_token
                }
            }, { error ->
                Log.e("login_debug", "ERROR: $error")
                _showProgressBar.value = !showProgressBar.value!!
                DialogError("Ocurrió un error de red").show(fragmentManager, "DialogError")
            })
    }
}