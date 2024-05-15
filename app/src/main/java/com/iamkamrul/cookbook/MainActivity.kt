package com.iamkamrul.cookbook

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.iamkamrul.cookbook.databinding.ActivityMainBinding
import com.iamkamrul.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun viewBindingLayout() = ActivityMainBinding.inflate(layoutInflater)

    private lateinit var navController:NavController
    override fun initializeView(savedInstanceState: Bundle?) {
        val navHostFragment = supportFragmentManager.findFragmentById(binding.mainNavHost.id) as NavHostFragment
        navController = navHostFragment.navController
        navController.handleDeepLink(intent)
    }

    //implement implicit deeplink example.com/kamrul
    // then navigate to singup fragment
//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//        navController.handleDeepLink(intent)
//    }

}