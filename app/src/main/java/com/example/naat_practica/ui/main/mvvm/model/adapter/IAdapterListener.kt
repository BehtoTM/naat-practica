package com.example.naat_practica.ui.main.mvvm.model.adapter

interface IAdapterListener<T> {
    fun onItemClickListener(model: T, position: Int)
}