package com.ramo.myapplication.core

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.ramo.myapplication.R
import com.ramo.myapplication.cusomviews.LoadingDialog
import com.ramo.sweetsdk.SweetViewModel
import com.ramo.sweetsdk.ext.findGenericWithType
import com.ramo.sweetsdk.ext.safeContext
import com.ramo.sweetsdk.state.NavEvent
import com.ramo.sweetsdk.ui.fragment.ViewBindingFragment

abstract class BaseFragment<VB : ViewBinding, VM : SweetViewModel> : ViewBindingFragment<VB>() {

    protected lateinit var viewModel: VM
    protected open fun isSharedViewModel(): Boolean = false
    private val exceptionDialog by lazy {
        AlertDialog.Builder(requireContext()).apply {
            setTitle(getString(R.string.error))
        }
    }

    protected val loadingDialog by lazy { LoadingDialog(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initViewModel() {
        val vmClass = javaClass.findGenericWithType<VM>(1)
        viewModel = ViewModelProvider(
            if (isSharedViewModel()) requireActivity() else this
        )[vmClass]
    }

    override fun sweetViewModel(): SweetViewModel? = viewModel

    override fun onChangeLoading(isLoading: Boolean) {
        if (isLoading) loadingDialog.show()
        else loadingDialog.dismiss()
    }

    override fun onAlert(stringId: Int, cancelable: Boolean) {
        safeContext {
            Toast.makeText(it, getString(stringId), Toast.LENGTH_LONG).show()
        }
    }

    override fun onException(throwable: Throwable, cancelable: Boolean) {
        exceptionDialog.apply {
            setPositiveButton(null, null)
            setMessage(throwable.localizedMessage)
            setNegativeButton(getString(R.string.ok)) { _, _ ->
                if (cancelable.not()) activity?.onBackPressed()
            }
        }.show()
    }


    override fun dismissAlertAndException() {
        exceptionDialog.create().dismiss()
    }

    override fun onNavigate(navEvent: NavEvent) {
        when (navEvent) {
            is NavEvent.Navigate -> findNavController().navigate(navEvent.navDirections)
            NavEvent.GoBack -> activity?.onBackPressed()
        }
    }
}