package com.example.naat_practica.ui.main.mvvm.views.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.naat_practica.core.base.BaseFragment
import com.example.naat_practica.core.builder.ViewModelProviderFactory
import com.example.naat_practica.core.db.entities.Companies
import com.example.naat_practica.databinding.FragmentMainBinding
import com.example.naat_practica.ui.main.mvvm.model.adapter.MainAdapter
import com.example.naat_practica.ui.main.mvvm.view_model.MainVM
import com.example.naat_practica.ui.main.mvvm.views.fragments.recharge.RechargeFragment
import com.example.naat_practica.ui.main.mvvm.model.adapter.IAdapterListener
import java.lang.Exception
import javax.inject.Inject

class MainFragment : BaseFragment(), IAdapterListener<Companies> {

    @Inject
    lateinit var factory: ViewModelProviderFactory<MainVM>

    lateinit var binding: FragmentMainBinding
    lateinit var mainVM: MainVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initModels()
        binding = FragmentMainBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MainFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)
        mainVM.list.observe(viewLifecycleOwner, Observer { list ->
            if (list.isEmpty()) mainVM.insertData()
            else binding.recyclerView.adapter = MainAdapter(context, this).apply { setData(list) }
        })
    }

    override fun onItemClickListener(model: Companies, position: Int) {
        mainVM.setItem(model)
        getBaseActivity()!!.setFragment(RechargeFragment())
    }

    private fun initModels() {
        mainVM = activity?.run { ViewModelProviders.of(this, factory)[MainVM::class.java] }
            ?: throw Exception("Invalid Activity")
    }
}