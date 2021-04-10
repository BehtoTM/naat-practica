package com.example.naat_practica.ui.main.mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.naat_practica.core.db.entities.Companies
import com.example.naat_practica.ui.main.data.interactor.MainInteractor
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainVM @Inject constructor(private val interactor: MainInteractor): ViewModel() {

    private val _amount  = MutableLiveData<Double>()
    private val _item    = MutableLiveData<Companies>()
    private val _phone   = MutableLiveData<String>()

    val amount : LiveData<Double>    get() = _amount
    val item   : LiveData<Companies> get() = _item
    val phone  : LiveData<String>    get() = _phone
    val list = interactor.getAllCompanies()

    val validData: Boolean = amount.value != null &&
            amount.value!! > 0.0 &&
            !phone.value.isNullOrEmpty() &&
            phone.value!!.length == 10

    fun insertData() {
        interactor.insertCompanies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    fun setItem(value: Companies) { _item.value = value }

    fun afterAmountTextChanged(editText: TextInputEditText) {
        val newText = editText.text.toString().replace("[^\\d]".toRegex(), "").toDouble() / 100
        if (newText != amount.value) {
            _amount.value = newText
        }
        editText.setSelection(editText.length())
    }

    fun afterPhoneTextChanged(editText: TextInputEditText) {
        val text = editText.text.toString()
        _phone.value = text
    }
}