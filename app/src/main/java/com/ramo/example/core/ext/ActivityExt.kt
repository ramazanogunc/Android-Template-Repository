package com.ramo.example.core.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData

fun <T> AppCompatActivity.observeExt(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(this) { it?.let { t -> observer(t) } }
}