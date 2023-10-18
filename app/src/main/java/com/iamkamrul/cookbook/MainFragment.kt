package com.iamkamrul.cookbook

import android.os.Bundle
import com.iamkamrul.cookbook.databinding.FragmentMainBinding
import com.iamkamrul.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun viewBindingLayout(): FragmentMainBinding  =
        FragmentMainBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {

    }
}