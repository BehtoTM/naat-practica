package com.example.naat_practica.ui.splash.di

import com.example.naat_practica.ui.splash.fragments.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashActivityModule {
    @ContributesAndroidInjector
    abstract fun provideSplashFragment(): SplashFragment
}