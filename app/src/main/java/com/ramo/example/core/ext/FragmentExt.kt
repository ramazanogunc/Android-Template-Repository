package com.ramo.example.core.ext

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun Fragment.safeContext(func: (Context) -> Unit) {
    context?.let(func)
}

fun <T> Fragment.observeExt(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { it?.let { t -> observer(t) } }
}