package com.iamkamrul.ui.base

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

 abstract class BaseListAdapter<T,V : ViewBinding>(
    diffCallback: DiffUtil.ItemCallback<T>
 ) : ListAdapter<T, BaseViewHolder<V>>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<V> {
        val binding = createBinding(parent)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {

        bind(holder.binding, getItem(position), position)
    }

    protected abstract fun createBinding(parent: ViewGroup): V
    protected abstract fun bind(binding: V, item: T, position: Int)
}


class BaseViewHolder<out T : ViewBinding> constructor(val binding: T) : RecyclerView.ViewHolder(binding.root)