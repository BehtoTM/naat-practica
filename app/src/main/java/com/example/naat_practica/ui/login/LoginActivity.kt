package com.example.naat_practica.ui.login

import android.os.Bundle
import com.example.naat_practica.core.base.BaseActivity
import com.example.naat_practica.databinding.ActivityLoginBinding
import com.example.naat_practica.ui.login.mvvm.views.fragments.LoginFragment

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(LoginFragment())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments

        if (fragments.size == 0) finish()
    }

    override fun getContainerView(): Int = binding.frameContainer.id
}