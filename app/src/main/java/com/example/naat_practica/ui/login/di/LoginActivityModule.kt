package com.example.naat_practica.ui.login.di

import com.example.naat_practica.ui.login.mvvm.views.fragments.LoginFragment
import com.example.naat_practica.ui.login.mvvm.di.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginActivityModule {
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginFragment(): LoginFragment
}