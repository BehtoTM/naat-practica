package com.example.naat_practica.core.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import javax.inject.Inject

class Preferences @Inject constructor(val context: Context) {

    companion object {
        private const val KEY_TOKEN = "KEY_TOKEN"
    }

    private val name = "${context.packageName}.${Preferences::class.java.simpleName}"

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, MODE_PRIVATE)

    fun getToken(): String? = sharedPreferences.getString(KEY_TOKEN, "")
    fun setToken(token: String?) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
    }
}