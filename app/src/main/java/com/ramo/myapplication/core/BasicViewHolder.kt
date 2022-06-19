package com.ramo.myapplication.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.ramo.sweetrecycler.VBSweetViewHolder

class BasicViewHolder<VB : ViewBinding, T>(
    inflater: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    viewGroup: ViewGroup?,
    private val onBind: (binding: VB, data: T) -> Unit
) : VBSweetViewHolder<VB, T>(
    inflater,
    viewGroup
) {
    override fun bind(data: T) {
        onBind.invoke(binding, data)
    }
}