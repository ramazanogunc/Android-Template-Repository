package com.ramo.example.ui.home

import com.ramo.example.core.BaseFragment
import com.ramo.example.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
  BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

  override fun init() {

  }

}