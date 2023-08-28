package com.ramo.example.customview

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable

class LoadingDialog(context: Context) : Dialog(context) {
    init {
        setContentView(R.layout.layout_loading)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(0))
    }
}