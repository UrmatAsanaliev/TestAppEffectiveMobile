package com.x.main.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class PlaceholderDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Нерабочий экран")
            .setMessage("На данный момент функция находиться на стадии разработки.")
            .setPositiveButton("Вернуться назад") { dialog, _ ->
                dialog.dismiss()
            }
        return builder.create()
    }
}