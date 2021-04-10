package com.example.naat_practica.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.content.ContextCompat
import com.example.naat_practica.application.BaseApplication
import java.util.*

object Converter {
    @JvmStatic
    fun amountToString(amount: Double): String {
        return String.format(Locale("es", "MX"), "$%,.2f", amount)
    }
    @JvmStatic
    fun getDrawableFromId(resourceId: Int): Drawable? {
        return ContextCompat.getDrawable(BaseApplication.appContext, resourceId)
    }
    @JvmStatic
    fun getVisibility(visibile: Boolean): Int {
        return if (visibile) VISIBLE else GONE
    }
}