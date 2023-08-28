package com.ramo.example.core.state

import androidx.annotation.StringRes

sealed class DialogEvent {
    class Error(val throwable: Throwable, val cancelable: Boolean) : DialogEvent()
    class Alert(@StringRes val messageResId: Int, val cancelable: Boolean = true) : DialogEvent()
    object None : DialogEvent()
}