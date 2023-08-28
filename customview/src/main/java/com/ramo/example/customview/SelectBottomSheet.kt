package com.ramo.example.customview

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ramo.example.customview.databinding.FragmentSelectBottomSheetBinding
import com.ramo.example.customview.databinding.ItemTextBinding
import com.ramo.sweetrecycler.VBSweetViewHolder

class SelectBottomSheet : BottomSheetDialogFragment() {

  private var onSelect: ((String) -> Unit)? = null
  private var list: List<String>? = null
  private var title: String? = null

  companion object {
    fun newInstance(title: String, list: List<String>, onSelect: (String) -> Unit) =
      SelectBottomSheet().apply {
        this.title = title
        this.list = list
        this.onSelect = onSelect
      }
  }

  override fun getTheme(): Int {
    return R.style.AppBottomSheetDialogTheme
  }


  private var _binding: FragmentSelectBottomSheetBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentSelectBottomSheetBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initUi()
  }

  private fun initUi() {
    binding.txtTitle.text = title
    if (list == null) return
    binding.rvList.render { parent: ViewGroup, _: Int, _: String ->
      return@render object : VBSweetViewHolder<ItemTextBinding, String>(
        ItemTextBinding::inflate,
        parent
      ) {
        override fun bind(data: String) {
          binding.txtName.text = data
        }

      }
    }
    binding.rvList.setOnItemClickListener { _, _, data: String ->
      dismissAllowingStateLoss()
      onSelect?.invoke(data)
    }
    binding.rvList.setData(list!!)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}