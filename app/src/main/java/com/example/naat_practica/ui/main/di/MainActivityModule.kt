package com.example.naat_practica.ui.main.di

import com.example.naat_practica.ui.main.mvvm.views.fragments.main.MainFragment
import com.example.naat_practica.ui.main.mvvm.views.fragments.recharge.RechargeFragment
import com.example.naat_practica.ui.main.mvvm.di.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainFragment(): MainFragment
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindRechargeFragment(): RechargeFragment
}