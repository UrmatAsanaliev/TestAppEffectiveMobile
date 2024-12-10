package com.x.main.ui.fragment.search

import android.content.Context
import android.content.DialogInterface
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import by.kirich1409.viewbindingdelegate.viewBinding
import com.x.core.base.BaseBottomSheetDialogFragment
import com.x.core.ext.OnTextSelectedListener
import com.x.main.R
import com.x.main.databinding.FragmentSearchBinding
import com.x.main.ui.dialog.PlaceholderDialogFragment

class SearchFragment(val from: String):
    BaseBottomSheetDialogFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override val binding: FragmentSearchBinding by viewBinding()

    override fun initialize() {
        binding.edFrom.setText(from)

        binding.edWhere.post {
            binding.edWhere.requestFocus()
            showKeyboard(binding.edWhere)
        }

    }

    override fun constructorListener() {
        binding.imgClear.setOnClickListener {
            binding.edFrom.text.clear()
        }

        binding.imgClear2.setOnClickListener {
            binding.edWhere.text.clear()
        }

        binding.stambul.setOnClickListener {
            binding.edWhere.setText(binding.txtStambul.text)
            dismiss()
        }

        binding.sochi.setOnClickListener {
            binding.edWhere.setText(binding.txtSochi.text)
            dismiss()
        }

        binding.phuket.setOnClickListener {
            binding.edWhere.setText(binding.txtPhuket.text)
            dismiss()
        }

        binding.hardWay.setOnClickListener {
            val dialog = PlaceholderDialogFragment()
            dialog.show(parentFragmentManager, "PlaceholderDialog")
        }

        binding.whereEver.setOnClickListener {
            binding.edWhere.setText(binding.txtWhereEver.text.toString())
        }

        binding.fireTickets.setOnClickListener {
            val dialog = PlaceholderDialogFragment()
            dialog.show(parentFragmentManager, "PlaceholderDialog")
        }

        binding.outDays.setOnClickListener {
            val dialog = PlaceholderDialogFragment()
            dialog.show(parentFragmentManager, "PlaceholderDialog")
        }

    }

    private fun showKeyboard(editText: EditText) {
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }

    private var listener: OnTextSelectedListener? = null

    fun setOnTextSelectedListener(listener: OnTextSelectedListener) {
        this.listener = listener
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        val from = binding.edFrom.text.toString()
        val where = binding.edWhere.text.toString()
        listener?.onTextSelected(from = from, where = where)
    }


}