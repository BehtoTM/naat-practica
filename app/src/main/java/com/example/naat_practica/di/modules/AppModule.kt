package com.example.naat_practica.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.naat_practica.application.BaseApplication
import com.example.naat_practica.core.db.database.AppDatabase
import com.example.naat_practica.core.preferences.Preferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesContext(application: BaseApplication): Context = application

    @Singleton
    @Provides
    fun providesRoomDB(application: BaseApplication): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "naat-db"
        ).build()
    }

    @Singleton
    @Provides
    fun providesSharedPreferences(context: Context): Preferences = Preferences(context)
}