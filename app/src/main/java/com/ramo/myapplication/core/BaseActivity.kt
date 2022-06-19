package com.ramo.myapplication.core

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.ramo.myapplication.R
import com.ramo.myapplication.cusomviews.LoadingDialog
import com.ramo.sweetsdk.SweetViewModel
import com.ramo.sweetsdk.ext.findGenericWithType
import com.ramo.sweetsdk.state.NavEvent
import com.ramo.sweetsdk.ui.activity.ViewBindingActivity

abstract class BaseActivity<VB : ViewBinding, VM : SweetViewModel> : ViewBindingActivity<VB>() {

    protected lateinit var viewModel: VM

    private val loadingDialog by lazy { LoadingDialog(this) }
    private val exceptionDialog by lazy {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.error))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel()
        super.onCreate(savedInstanceState)
    }

    private fun initViewModel() {
        val vmClass = javaClass.findGenericWithType<VM>(1)
        viewModel = ViewModelProvider(this)[vmClass]
    }

    override fun sweetViewModel(): SweetViewModel? = viewModel

    override fun onChangeLoading(isLoading: Boolean) {
        if (isLoading) loadingDialog.show()
        else loadingDialog.dismiss()
    }

    override fun onAlert(stringId: Int, cancelable: Boolean) {
        Toast.makeText(this, getString(stringId), Toast.LENGTH_SHORT).show()
    }

    override fun onException(throwable: Throwable, cancelable: Boolean) {
        exceptionDialog.apply {
            setPositiveButton(null, null)
            setMessage(throwable.localizedMessage)
            setNegativeButton(getString(R.string.ok)) { _, _ ->
                if (cancelable.not()) onBackPressed()
            }
        }.show()
    }

    override fun dismissAlertAndException() {
        exceptionDialog.create().dismiss()
    }

    override fun onNavigate(navEvent: NavEvent) {}
}