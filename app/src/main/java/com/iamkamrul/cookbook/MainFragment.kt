package com.iamkamrul.cookbook

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.iamkamrul.cookbook.databinding.FragmentMainBinding
import com.iamkamrul.ui.adapter.FeaturesComponentAdapter
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.setUpGridRecyclerViewAdapter

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun viewBindingLayout(): FragmentMainBinding  =
        FragmentMainBinding.inflate(layoutInflater)

    private val features = listOf("Navigation", "Material Component")
    private val adapter by lazy { FeaturesComponentAdapter{position->
        when(position){
            0 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
        }
    }}

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
        configureRecyclerViewWithAdapter()
    }

    private fun configureRecyclerViewWithAdapter(){
        requireContext().setUpGridRecyclerViewAdapter(binding.componentRv,adapter,2)
        adapter.submitList(features)
    }

    private fun configureTopAppbar(){
        binding.incTopAppbarLayout.topAppBar.title = "Home"
    }
}