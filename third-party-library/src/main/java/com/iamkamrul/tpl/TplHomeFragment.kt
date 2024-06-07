package com.iamkamrul.tpl

import android.os.Bundle
import com.iamkamrul.tpl.databinding.FragmentTplHomeBinding
import com.iamkamrul.ui.adapter.FeaturesComponentAdapter
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.navigate
import com.iamkamrul.ui.extension.setUpGridRecyclerViewAdapter

class TplHomeFragment : BaseFragment<FragmentTplHomeBinding>(){
    override fun viewBindingLayout(): FragmentTplHomeBinding = FragmentTplHomeBinding.inflate(layoutInflater)


    private val libs = listOf("SignalR", "Retrofit")
    private val adapter by lazy { FeaturesComponentAdapter { position ->
        when (position) {
            0->navigate(TplHomeFragmentDirections.actionTplHomeFragmentToSignalrFragment())
            1->{}
        }
    }}

    override fun initializeView(savedInstanceState: Bundle?) {
        binding.incTopAppbar.topAppBar.title = "Third Party Library"
        configureRecyclerViewWithAdapter()
    }

    private fun configureRecyclerViewWithAdapter(){
        requireContext().setUpGridRecyclerViewAdapter(binding.componentRv,adapter,2)
        adapter.submitList(libs)
    }

}