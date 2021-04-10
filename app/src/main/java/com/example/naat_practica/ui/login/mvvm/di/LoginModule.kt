package com.example.naat_practica.ui.login.mvvm.di

import com.example.naat_practica.core.builder.ViewModelProviderFactory
import com.example.naat_practica.core.preferences.Preferences
import com.example.naat_practica.ui.login.data.interactors.LoginInteractor
import com.example.naat_practica.ui.login.data.repository.LoginRepository
import com.example.naat_practica.ui.login.mvvm.view_model.LoginVM
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    fun providesLoginVM(interactor: LoginInteractor, preferences: Preferences) = LoginVM(interactor, preferences)

    @Provides
    fun providesViewModelFactory(viewModel: LoginVM) = ViewModelProviderFactory(viewModel)

    @Provides
    fun providesLoginInteractor(repository: LoginRepository) = LoginInteractor(repository)

    @Provides
    fun providesLoginRepository() = LoginRepository()
}