package com.ramo.myapplication.core

import com.ramo.sweetsdk.SweetViewModel

abstract class BaseViewModel : SweetViewModel() {

    override fun handleSafeException(e: Exception) {
        when (e) {
            // TODO: hande custom exception
            else -> showError(e)
        }
    }
}