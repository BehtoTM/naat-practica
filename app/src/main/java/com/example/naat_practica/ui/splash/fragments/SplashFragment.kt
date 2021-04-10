package com.example.naat_practica.ui.splash.fragments

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.naat_practica.core.base.BaseFragment
import com.example.naat_practica.databinding.FragmentSplashBinding
import com.example.naat_practica.ui.login.LoginActivity

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBaseActivity()!!.finish()
        getBaseActivity()!!.startActivity(
                Intent(getBaseActivity()!!, LoginActivity::class.java)
                        .setFlags(FLAG_ACTIVITY_SINGLE_TOP)
        )
    }
}