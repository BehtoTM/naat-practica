package com.example.naat_practica.ui.main.mvvm.model.pojo

import com.example.naat_practica.R
import com.example.naat_practica.core.db.entities.Companies

class CompaniesPOJO {
    companion object {
        fun companiesList(): List<Companies> {
            val claro1 = Companies(1, "Claro", "Tiempo aire", R.drawable.ic_claro)
            val claro2 = Companies(2, "Claro", "Megas", R.drawable.ic_claro)
            val claro3 = Companies(3, "Claro", "Tiempo aire", R.drawable.ic_claro)

            val tuenti1 = Companies(11, "Tuenti", "Tiempo aire", R.drawable.ic_tuenti)
            val tuenti2 = Companies(12, "Tuenti", "Megas", R.drawable.ic_tuenti)
            val tuenti3 = Companies(13, "Tuenti", "Tiempo aire", R.drawable.ic_tuenti)

            val entel1 = Companies(21, "Entel", "Tiempo aire", R.drawable.ic_entel)
            val entel2 = Companies(22, "Entel", "Megas", R.drawable.ic_entel)
            val entel3 = Companies(23, "Entel", "Tiempo aire", R.drawable.ic_entel)

            return listOf(
                claro1, claro2, claro3,
                tuenti1, tuenti2, tuenti3,
                entel1, entel2, entel3
            )
        }
    }
}