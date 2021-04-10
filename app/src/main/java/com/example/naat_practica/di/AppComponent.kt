package com.example.naat_practica.di

import com.example.naat_practica.application.BaseApplication
import com.example.naat_practica.di.modules.ActivityModule
import com.example.naat_practica.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): AppComponent
    }
}