package com.iamkamrul.navigation.signup

import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.iamkamrul.navigation.singup.R
import com.iamkamrul.navigation.singup.databinding.FragmentSignupBinding
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.navigate

class SignupFragment : BaseFragment<FragmentSignupBinding>() {
    override fun viewBindingLayout(): FragmentSignupBinding  =
        FragmentSignupBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()

        binding.loginNowBtn.setOnClickListener {
            navigate(
                getString(R.string.deep_link_login_fragment).toUri(),
                popupToId = R.id.loginFragment,
                popupToInclusive = true
            )
        }
    }

    private fun configureTopAppbar(){
        binding.incTopAppbarLayout.topAppBar.title = "Signup"
        binding.incTopAppbarLayout.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbarLayout.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}