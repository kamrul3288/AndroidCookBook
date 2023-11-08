package com.iamkamrul.material

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.iamkamrul.material.databinding.FragmentMaterialHomeBinding
import com.iamkamrul.ui.adapter.FeaturesComponentAdapter
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.navigate
import com.iamkamrul.ui.extension.setUpGridRecyclerViewAdapter


class MaterialHomeFragment : BaseFragment<FragmentMaterialHomeBinding>(){
    override fun viewBindingLayout(): FragmentMaterialHomeBinding = FragmentMaterialHomeBinding.inflate(layoutInflater)

    private val features = listOf("Menu","Button")
    private val adapter by lazy { FeaturesComponentAdapter{position->
        when(position) {
            0 -> navigate(MaterialHomeFragmentDirections.actionMaterialHomeFragmentToMenuFragment())
            1 -> navigate(MaterialHomeFragmentDirections.actionMaterialHomeFragmentToButtonFragment())
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
        binding.incTopAppbar.topAppBar.title = "Material"
        binding.incTopAppbar.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbar.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}