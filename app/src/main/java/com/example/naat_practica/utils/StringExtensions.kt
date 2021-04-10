package com.example.naat_practica.utils

import android.util.Patterns

fun String?.validEmail(): Boolean {
    return !this.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}