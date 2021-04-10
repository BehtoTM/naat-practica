package com.example.naat_practica.ui.main.data.repository

import androidx.lifecycle.LiveData
import com.example.naat_practica.core.db.database.AppDatabase
import com.example.naat_practica.core.db.entities.Companies
import com.example.naat_practica.ui.main.mvvm.model.pojo.CompaniesPOJO
import io.reactivex.Completable
import javax.inject.Inject

class MainRepository @Inject constructor(private val db: AppDatabase): IMainRepository {

    override fun getAllCompanies(): LiveData<List<Companies>> = db.companiesDao().getAll()

    override fun insertCompanies(): Completable = db.companiesDao().insertAll(CompaniesPOJO.companiesList())
}