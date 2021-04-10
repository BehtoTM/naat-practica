package com.example.naat_practica.core.base

import android.content.Context
import com.example.naat_practica.application.BaseApplication
import com.example.naat_practica.core.base.BaseActivity
import dagger.android.support.DaggerFragment

open class BaseFragment: DaggerFragment() {

    private var activity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity: BaseActivity = context
            this.activity = activity
        }
    }

    override fun onDetach() {
        this.activity = null
        super.onDetach()
    }

    fun getBaseActivity(): BaseActivity? {
        return this.activity
    }

    override fun getContext(): Context = BaseApplication.appContext
}