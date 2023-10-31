package com.iamkamrul.navigation.otpverify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.iamkamrul.common.extension.decode
import com.iamkamrul.entity.navigation.OtpVerifyArgs
import com.iamkamrul.navigation.otpverify.databinding.FragmentOtpVerifyBinding
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtpVerifyFragment : BaseFragment<FragmentOtpVerifyBinding>() {
    override fun viewBindingLayout(): FragmentOtpVerifyBinding =
        FragmentOtpVerifyBinding.inflate(layoutInflater)

    @Inject lateinit var gson: Gson
    private val jsonArgs by navArgs<OtpVerifyFragmentArgs>()
    private val args: OtpVerifyArgs by lazy {
        gson.fromJson(jsonArgs.otpVerifyArgs.decode(), OtpVerifyArgs::class.java)
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
        binding.messageTv.text = "We send otp code: ${args.phoneNumber}"

        binding.otpVerifyBtn.setOnClickListener {
            navigate(getString(R.string.deep_link_signup_fragment).toUri())
        }
    }

    private fun configureTopAppbar(){
        binding.incTopAppbarLayout.topAppBar.title = "Otp Verify"
        binding.incTopAppbarLayout.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbarLayout.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}