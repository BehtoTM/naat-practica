package com.example.naat_practica.di.modules

import com.example.naat_practica.ui.login.LoginActivity
import com.example.naat_practica.ui.login.di.LoginActivityModule
import com.example.naat_practica.ui.main.MainActivity
import com.example.naat_practica.ui.main.di.MainActivityModule
import com.example.naat_practica.ui.splash.SplashActivity
import com.example.naat_practica.ui.splash.di.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}