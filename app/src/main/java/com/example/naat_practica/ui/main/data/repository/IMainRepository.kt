package com.example.naat_practica.ui.main.data.repository

import androidx.lifecycle.LiveData
import com.example.naat_practica.core.db.entities.Companies
import io.reactivex.Completable

interface IMainRepository {
    fun getAllCompanies(): LiveData<List<Companies>>
    fun insertCompanies(): Completable
}