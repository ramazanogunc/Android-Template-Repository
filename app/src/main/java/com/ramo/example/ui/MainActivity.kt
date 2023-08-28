package com.ramo.example.ui

import com.ramo.example.R
import com.ramo.example.core.BaseActivity
import com.ramo.example.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override fun init() = Unit
}