package com.iamkamrul.navigation.login

import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.iamkamrul.common.extension.encode
import com.iamkamrul.entity.navigation.OtpVerifyArgs
import com.iamkamrul.navigation.login.databinding.FragmentLoginBinding
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.navigate


class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun viewBindingLayout(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
        binding.loginBtn.setOnClickListener {
            navigate(
                getString(
                    R.string.deep_link_otp_verify_fragment_args,
                    Gson().toJson(OtpVerifyArgs("+8801915101010")).encode()
                ).toUri())
        }
    }

    private fun configureTopAppbar(){
        binding.incTopAppbarLayout.topAppBar.title = "Login"
        binding.incTopAppbarLayout.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbarLayout.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}