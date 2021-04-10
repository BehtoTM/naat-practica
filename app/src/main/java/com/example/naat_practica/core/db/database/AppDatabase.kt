package com.example.naat_practica.core.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.naat_practica.core.db.dao.CompaniesDao
import com.example.naat_practica.core.db.entities.Companies

@Database(entities = [Companies::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun companiesDao(): CompaniesDao
}