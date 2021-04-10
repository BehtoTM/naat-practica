package com.example.naat_practica.ui.splash

import android.os.Bundle
import com.example.naat_practica.core.base.BaseActivity
import com.example.naat_practica.databinding.ActivitySplashBinding
import com.example.naat_practica.ui.splash.fragments.SplashFragment

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(SplashFragment())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments

        if (fragments.size == 0) finish()
    }

    override fun getContainerView(): Int = binding.frameContainer.id
}