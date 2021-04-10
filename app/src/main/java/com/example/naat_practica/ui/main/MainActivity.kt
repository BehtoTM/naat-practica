package com.example.naat_practica.ui.main

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.naat_practica.core.base.BaseActivity
import com.example.naat_practica.databinding.ActivityMainBinding
import com.example.naat_practica.ui.main.mvvm.views.dialogs.DialogConfirmation
import com.example.naat_practica.ui.main.mvvm.views.dialogs.DialogSuccess
import com.example.naat_practica.ui.main.mvvm.views.fragments.main.MainFragment

class MainActivity: BaseActivity(), DialogConfirmation.DialogConfirmationListener {

    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(MainFragment())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments

        if (fragments.size == 0) finish()
    }

    override fun getContainerView(): Int = binding.frameContainer.id

    override fun onCancelClick(dialog: DialogFragment) {
        dialog.dismiss()
    }

    override fun onAcceptClick(dialog: DialogFragment) {
        DialogSuccess().show(supportFragmentManager, "DialogSuccess")
    }
}