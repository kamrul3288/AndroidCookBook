package com.iamkamrul.phonebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.iamkamrul.phonebook.databinding.ItemContactListBinding
import com.iamkamrul.phonebook.databinding.ItemContactSectionBinding

class ContactListAdapter : RecyclerView.Adapter<ViewHolder>(){
    private var contactList = listOf<ContactItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ContactViewType.section -> SectionViewHolder(ItemContactSectionBinding.inflate(inflater,parent,false))
            ContactViewType.items -> ItemViewHolder(ItemContactListBinding.inflate(inflater,parent,false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    class ItemViewHolder(val binding: ItemContactListBinding) : ViewHolder(binding.root)
    class SectionViewHolder(val binding: ItemContactSectionBinding) : ViewHolder(binding.root)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            if (contactList[position].name.length>2){
                holder.binding.headerTv.text = contactList[position].name.substring(0,2).uppercase()
            }else{
                holder.binding.headerTv.text = contactList[position].name
            }
            holder.binding.phoneNameTv.text = contactList[position].name

        }else if (holder is SectionViewHolder){
            holder.binding.titleTv.text = contactList[position].sectionTitle
        }
    }

    override fun getItemCount(): Int = contactList.size

    override fun getItemViewType(position: Int): Int {
        return when(contactList[position].viewType){
            ContactViewType.section -> ContactViewType.section
            ContactViewType.items -> ContactViewType.items
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    fun submitList(contactList:List<ContactItem>){
        this.contactList = contactList
        notifyDataSetChanged()
    }
}