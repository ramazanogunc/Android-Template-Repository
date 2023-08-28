package com.ramo.example.core.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter


object ViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("bind:visible")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("bind:onSafeClick")
    fun View.onSafeClick(onClick: () -> Unit) {
        setOnClickListener(SafeClickListener {
            onClick()
        })
    }
}