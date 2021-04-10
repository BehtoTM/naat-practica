package com.example.naat_practica.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.naat_practica.core.db.entities.Companies
import io.reactivex.Completable

@Dao
interface CompaniesDao {
    @Query("SELECT * FROM companies ORDER BY company_name")
    fun getAll(): LiveData<List<Companies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(companies: List<Companies>): Completable

    @Delete
    fun delete(companies: Companies): Completable
}