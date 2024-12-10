package com.x.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment<Binding: ViewBinding>(
    @LayoutRes layoutId: Int
) : BottomSheetDialogFragment(layoutId) {

    protected abstract val binding: Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        constructorListener()
    }

    protected open fun constructorListener() {

    }

    protected open fun initialize() {}
}