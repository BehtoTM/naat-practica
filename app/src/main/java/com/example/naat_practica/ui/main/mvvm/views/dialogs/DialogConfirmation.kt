package com.example.naat_practica.ui.main.mvvm.views.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.naat_practica.databinding.DialogConfirmationBinding
import com.example.naat_practica.ui.main.mvvm.view_model.MainVM
import java.lang.ClassCastException
import java.lang.IllegalStateException

class DialogConfirmation(private val mainVM: MainVM): DialogFragment() {

    private lateinit var binding: DialogConfirmationBinding
    private lateinit var listener: DialogConfirmationListener

    interface DialogConfirmationListener {
        fun onCancelClick(dialog: DialogFragment)
        fun onAcceptClick(dialog: DialogFragment)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            binding = DialogConfirmationBinding.inflate(inflater).apply {
                viewModel = mainVM
            }

            binding.btnCancel.setOnClickListener { listener.onCancelClick(this) }
            binding.btnAccept.setOnClickListener { listener.onAcceptClick(this) }

            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as DialogConfirmationListener
        }  catch (e: ClassCastException) {
            throw ClassCastException("$context must implement DialogConfirmationListener")
        }
    }
}