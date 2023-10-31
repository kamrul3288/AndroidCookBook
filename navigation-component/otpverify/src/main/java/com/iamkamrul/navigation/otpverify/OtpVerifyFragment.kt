package com.iamkamrul.navigation.otpverify

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.iamkamrul.navigation.otpverify.databinding.FragmentOtpVerifyBinding
import com.iamkamrul.ui.base.BaseFragment


class OtpVerifyFragment : BaseFragment<FragmentOtpVerifyBinding>() {
    override fun viewBindingLayout(): FragmentOtpVerifyBinding =
        FragmentOtpVerifyBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
    }

    private fun configureTopAppbar(){
        binding.incTopAppbarLayout.topAppBar.title = "Otp Verify"
        binding.incTopAppbarLayout.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbarLayout.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}