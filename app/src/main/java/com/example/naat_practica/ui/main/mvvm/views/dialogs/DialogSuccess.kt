package com.example.naat_practica.ui.main.mvvm.views.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.naat_practica.databinding.DialogSuccessBinding
import java.lang.ClassCastException
import java.lang.IllegalStateException

class DialogSuccess: DialogFragment() {

    private lateinit var binding: DialogSuccessBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            binding = DialogSuccessBinding.inflate(inflater)

            binding.btnAccept.setOnClickListener {
                this.dismiss()
                requireActivity().onBackPressed()
            }

            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}