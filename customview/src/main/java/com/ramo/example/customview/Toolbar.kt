package com.ramo.example.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.core.view.isVisible
import com.ramo.example.customview.core.activity
import com.ramo.example.customview.databinding.ToolbarBinding

/**
 * Created by ramazanogunc
 * Created at 17.08.2023
 */
class Toolbar @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

  private val binding: ToolbarBinding =
    ToolbarBinding.inflate(LayoutInflater.from(context), this, true)

  var title: String? = null
    set(value) {
      binding.txtTitle.isVisible = value.isNullOrEmpty().not()
      binding.txtTitle.text = value
      field = value
    }

  init {
    context.obtainStyledAttributes(attributeSet, R.styleable.Toolbar).apply {
      val titleParam = getString(R.styleable.Toolbar_t_title)
      val canBack: Boolean = getBoolean(R.styleable.Toolbar_t_can_back, false)

      recycle()
      title = titleParam
      binding.btnBack.isVisible = canBack
      binding.btnBack.setOnClickListener {
        val activity = context.activity()
        if (activity is ComponentActivity) {
          activity.onBackPressedDispatcher.onBackPressed()
        }
      }
    }
  }


}
