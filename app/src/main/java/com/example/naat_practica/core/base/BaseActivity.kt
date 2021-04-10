package com.example.naat_practica.core.base

import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity() {

    fun setFragment(fragment: BaseFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        
        fragmentTransaction
                .replace(getContainerView(), fragment)
                .addToBackStack(null)
                .commit()
    }

    abstract fun getContainerView(): Int
}