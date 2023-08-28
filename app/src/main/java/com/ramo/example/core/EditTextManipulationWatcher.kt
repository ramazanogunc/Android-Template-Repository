package com.ramo.example.core

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
class EditTextManipulationWatcher(
  private val change: (Editable) -> Unit
) : TextWatcher {
  private var byUser = true


  override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

  override fun afterTextChanged(s: Editable?) {
    if (!byUser) return

    byUser = false
    s?.let {
      change(it)
    }
    byUser = true
  }
}