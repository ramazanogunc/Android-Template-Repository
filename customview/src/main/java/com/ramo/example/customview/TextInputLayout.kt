package com.ramo.example.customview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.google.android.material.textfield.TextInputLayout
import com.ramo.example.customview.core.toPx

/**
 * Created by ramazanogunc
 * Created at 18.08.2023
 */
class TextInputLayout @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0
) : TextInputLayout(
  ContextThemeWrapper(
    context,
    com.google.android.material.R.style.Widget_MaterialComponents_TextInputLayout_FilledBox
  ), attributeSet, defStyleAttr
) {

  private val txtError by lazy {
    TextView(context).apply {
      layoutParams = LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.WRAP_CONTENT,
      )
      setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_error, 0, 0, 0)
      compoundDrawablePadding = 8.toPx()
      setTextColor(ContextCompat.getColor(context, R.color.error_red))
    }
  }


  init {
    boxStrokeColor = Color.TRANSPARENT
    boxBackgroundColor = Color.TRANSPARENT
    boxStrokeWidth = 0
    boxStrokeWidthFocused = 0
    getChildAt(0).setBackgroundResource(R.drawable.bg_text_input_layout)
//    getChildAt(0).setBackgroundResource(R.drawable.bg_text_input_selector)
    val textColor = ContextCompat.getColor(context, R.color.primaryVariantTextColor)
    val hintColor = ColorStateList.valueOf(textColor)
    hintTextColor = hintColor
    defaultHintTextColor = hintColor
    boxBackgroundMode = BOX_BACKGROUND_FILLED
    setErrorTextColor(
      ColorStateList.valueOf(ContextCompat.getColor(context, R.color.error_red))
    )
  }

  override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
    super.addView(child, index, params)
    editText?.setOnFocusChangeListener { _, _ -> updateBackground() }
    editText?.setBackgroundColor(Color.TRANSPARENT)
  }

  fun error(@StringRes errorId: Int?) {
    error = if (errorId == null) {
      null
    } else {
      context.getString(errorId)
    }
  }

  override fun setError(errorText: CharSequence?) {
    txtError.text = errorText
    if (errorText.isNullOrBlank()) {
      removeView(txtError)
      updateBackground()
      return
    }

    if (children.any { it == txtError }.not())
      addView(txtError)
    updateBackground()
  }

  override fun getError(): CharSequence? {
    return txtError.text
  }

  val isValid: Boolean get() = error.isNullOrBlank()

  private fun updateBackground() {
    getChildAt(0).setBackgroundResource(
      if (editText?.isFocused == true)
        R.drawable.bg_text_input_layout_focused
      else if (txtError.text.isNullOrBlank().not())
        R.drawable.bg_text_input_layout_error
      else
        R.drawable.bg_text_input_layout
    )
  }


}