package com.example.naat_practica.ui.main.data.interactor

import androidx.lifecycle.LiveData
import com.example.naat_practica.core.db.entities.Companies
import com.example.naat_practica.ui.main.data.repository.MainRepository
import io.reactivex.Completable
import javax.inject.Inject

class MainInteractor @Inject constructor(private val repository: MainRepository): IMainInteractor {
    override fun getAllCompanies(): LiveData<List<Companies>> = repository.getAllCompanies()
    override fun insertCompanies(): Completable = repository.insertCompanies()
}