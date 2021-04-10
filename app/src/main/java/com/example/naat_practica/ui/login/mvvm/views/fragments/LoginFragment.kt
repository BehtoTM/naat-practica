package com.example.naat_practica.ui.login.mvvm.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.naat_practica.core.base.BaseActivity
import com.example.naat_practica.core.base.BaseFragment
import com.example.naat_practica.core.builder.ViewModelProviderFactory
import com.example.naat_practica.databinding.FragmentLoginBinding
import com.example.naat_practica.ui.login.mvvm.view_model.LoginVM
import com.example.naat_practica.ui.main.MainActivity
import javax.inject.Inject

class LoginFragment: BaseFragment(), View.OnClickListener {

    @Inject
    lateinit var factory: ViewModelProviderFactory<LoginVM>

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginVM: LoginVM

    private val observer = Observer<String> { token ->
        if (token != null) {
            getBaseActivity()!!.finish()
            startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false).also {
            initModels()
            it.lifecycleOwner = this
            it.listener = this
            it.loginVM = loginVM
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginVM.token.observe(viewLifecycleOwner, observer)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.btnLogin.id -> {
                loginVM.login(getBaseActivity()!!.supportFragmentManager)
            }
        }
    }

    private fun initModels() {
        loginVM = activity?.run { ViewModelProviders.of(this, factory)[LoginVM::class.java] }
            ?: throw Exception("Invalid Activity")
    }
}