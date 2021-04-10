package com.example.naat_practica.ui.main.data.interactor

import androidx.lifecycle.LiveData
import com.example.naat_practica.core.db.entities.Companies
import io.reactivex.Completable

interface IMainInteractor {
    fun getAllCompanies(): LiveData<List<Companies>>
    fun insertCompanies(): Completable
}