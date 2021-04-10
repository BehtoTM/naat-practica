package com.example.naat_practica.ui.main.mvvm.model.adapter

import android.content.Context
import com.example.naat_practica.R
import com.example.naat_practica.core.base.BaseAdapter
import com.example.naat_practica.core.db.entities.Companies
import com.example.naat_practica.databinding.ItemGridCompanyBinding

class MainAdapter(context: Context, val listener: IAdapterListener<Companies>): BaseAdapter<ItemGridCompanyBinding, Companies>(context) {
    override fun getLayoutResId(): Int = R.layout.item_grid_company

    override fun onBindData(model: Companies, position: Int, binding: ItemGridCompanyBinding) {
        binding.listener = listener
        binding.position = position
        binding.model = model
    }
}