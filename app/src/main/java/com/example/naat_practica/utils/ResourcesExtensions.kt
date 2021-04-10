package com.example.naat_practica.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

fun Context.drawable(resourceId: Int): Drawable? {
    return ContextCompat.getDrawable(this, resourceId)
}