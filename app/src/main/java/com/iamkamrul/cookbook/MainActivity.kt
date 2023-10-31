package com.iamkamrul.cookbook

import android.os.Bundle
import com.iamkamrul.cookbook.databinding.ActivityMainBinding
import com.iamkamrul.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun viewBindingLayout(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {

    }

}