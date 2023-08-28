package com.ramo.example.customview.core

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

/**
 * Created by ramazanogunc
 * Created at 18.08.2023
 */


tailrec fun Context.activity(): Activity? = when (this) {
  is Activity -> this
  else -> (this as? ContextWrapper)?.baseContext?.activity()
}
