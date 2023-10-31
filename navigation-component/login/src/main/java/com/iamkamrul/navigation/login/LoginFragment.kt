package com.iamkamrul.navigation.login

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.iamkamrul.navigation.login.databinding.FragmentLoginBinding
import com.iamkamrul.ui.base.BaseFragment


class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun viewBindingLayout(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
    }

    private fun configureTopAppbar(){
        binding.incTopAppbarLayout.topAppBar.title = "Login"
        binding.incTopAppbarLayout.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbarLayout.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}