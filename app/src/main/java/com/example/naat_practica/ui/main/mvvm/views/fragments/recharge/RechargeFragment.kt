package com.example.naat_practica.ui.main.mvvm.views.fragments.recharge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.naat_practica.core.base.BaseFragment
import com.example.naat_practica.core.builder.ViewModelProviderFactory
import com.example.naat_practica.databinding.FragmentRechargeBinding
import com.example.naat_practica.ui.main.mvvm.view_model.MainVM
import com.example.naat_practica.ui.main.mvvm.views.dialogs.DialogConfirmation
import com.example.naat_practica.ui.main.mvvm.views.dialogs.DialogSuccess
import javax.inject.Inject

class RechargeFragment : BaseFragment(), View.OnClickListener {

    @Inject
    lateinit var factory: ViewModelProviderFactory<MainVM>

    lateinit var binding: FragmentRechargeBinding
    lateinit var mainVM: MainVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initModels()
        binding = FragmentRechargeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@RechargeFragment
            listener = this@RechargeFragment
            viewModel = mainVM
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            binding.btnContinue.id -> {
                DialogConfirmation(mainVM)
                        .show(getBaseActivity()!!.supportFragmentManager, "DialogConfirmation")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initModels() {
        mainVM = activity?.run { ViewModelProviders.of(this)[MainVM::class.java] }
                ?: throw Exception("Invalid Activity")
    }

    private fun setToolbar() {
        getBaseActivity()!!.setSupportActionBar(binding.toolbar)
        getBaseActivity()!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        getBaseActivity()!!.supportActionBar!!.title = null
    }
}