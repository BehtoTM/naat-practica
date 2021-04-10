package com.example.naat_practica.ui.main.mvvm.di

import com.example.naat_practica.core.builder.ViewModelProviderFactory
import com.example.naat_practica.core.db.database.AppDatabase
import com.example.naat_practica.ui.main.data.interactor.MainInteractor
import com.example.naat_practica.ui.main.data.repository.MainRepository
import com.example.naat_practica.ui.main.mvvm.view_model.MainVM
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun providesMainVM(interactor: MainInteractor) = MainVM(interactor)

    @Provides
    fun providesViewModelFactory(viewModel: MainVM) = ViewModelProviderFactory(viewModel)

    @Provides
    fun providesMainInteractor(repository: MainRepository) = MainInteractor(repository)

    @Provides
    fun providesMainRepository(db: AppDatabase) = MainRepository(db)
}