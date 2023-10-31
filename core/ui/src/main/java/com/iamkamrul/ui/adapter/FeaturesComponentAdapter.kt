package com.iamkamrul.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.iamkamrul.ui.base.BaseListAdapter
import com.iamkamrul.ui.databinding.ItemFeatureComponentBinding

class FeaturesComponentAdapter(
    private val onItemClick:(Int)->Unit
) : BaseListAdapter<String,ItemFeatureComponentBinding>(
    diffCallback = object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean  = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
){
    override fun createBinding(parent: ViewGroup): ItemFeatureComponentBinding =
        ItemFeatureComponentBinding.inflate(LayoutInflater.from(parent.context),parent,false)

    override fun bind(binding: ItemFeatureComponentBinding, item: String, position: Int) {
        binding.nameTv.text = item
        binding.root.setOnClickListener {
            onItemClick(position)
        }
    }

}