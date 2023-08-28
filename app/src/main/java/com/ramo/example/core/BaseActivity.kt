package com.ramo.example.core

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.ramo.example.R
import com.ramo.example.core.ext.findGenericWithType
import com.ramo.example.core.ext.observeExt
import com.ramo.example.core.state.DialogEvent
import com.ramo.example.core.state.NavEvent
import com.ramo.example.customview.LoadingDialog

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel>(
    private val inflater: (LayoutInflater) -> VB
) : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    private val loadingDialog by lazy { LoadingDialog(this) }
    private val exceptionDialog by lazy {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.error))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflater.invoke(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initCommonObserver()
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected fun withBinding(block: VB.() -> Unit) {
        with(binding, block)
    }

    private fun initCommonObserver() {
        observeExt(viewModel.isLoading) { isLoading -> onChangeLoading(isLoading) }
        observeExt(viewModel.dialogEvent) { dialogEvent ->
            dismissAlertAndException()
            if (dialogEvent is DialogEvent.Alert)
                onAlert(dialogEvent.messageResId, dialogEvent.cancelable)
            else if (dialogEvent is DialogEvent.Error)
                onException(dialogEvent.throwable, dialogEvent.cancelable)

        }
        observeExt(viewModel.navigationEvent) { navEvent -> onNavigate(navEvent) }
    }


    private fun initViewModel() {
        val vmClass = javaClass.findGenericWithType<VM>(1)
        viewModel = ViewModelProvider(this)[vmClass]
    }

    protected open fun onChangeLoading(isLoading: Boolean) {
        if (isLoading) loadingDialog.show()
        else loadingDialog.dismiss()
    }

    protected open fun onAlert(stringId: Int, cancelable: Boolean) {
        Toast.makeText(this, getString(stringId), Toast.LENGTH_SHORT).show()
    }

    protected open fun onException(throwable: Throwable, cancelable: Boolean) {
        exceptionDialog.apply {
            setPositiveButton(null, null)
            setMessage(throwable.localizedMessage)
            setNegativeButton(getString(R.string.ok)) { _, _ ->
                if (cancelable.not()) onBackPressedDispatcher.onBackPressed()
            }
        }.show()
    }

    protected open fun dismissAlertAndException() {
        exceptionDialog.create().dismiss()
    }

    protected open fun onNavigate(navEvent: NavEvent) {}

    protected abstract fun init()
}