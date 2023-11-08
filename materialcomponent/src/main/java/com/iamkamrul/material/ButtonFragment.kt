package com.iamkamrul.material

import android.os.Bundle
import com.iamkamrul.material.databinding.FragmentButtonBinding
import com.iamkamrul.ui.base.BaseFragment

class ButtonFragment : BaseFragment<FragmentButtonBinding>() {
    override fun viewBindingLayout() = FragmentButtonBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {

    }
}