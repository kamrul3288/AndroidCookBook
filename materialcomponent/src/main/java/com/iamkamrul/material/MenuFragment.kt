package com.iamkamrul.material

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import androidx.annotation.MenuRes
import androidx.navigation.fragment.findNavController
import com.iamkamrul.material.databinding.FragmentMenuBinding
import com.iamkamrul.material.databinding.ItemExposeDropdownMenuBinding
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.dp

//https://github.com/material-components/material-components-android/blob/master/docs/components/Menu.md

class MenuFragment : BaseFragment<FragmentMenuBinding>(){
    override fun viewBindingLayout() = FragmentMenuBinding.inflate(layoutInflater)

    private val items = listOf("Item - 1", "Item - 2","Item - 3","Item - 4","Item - 5","Item - 6","Item - 7","Item - 8","Item - 9","Item - 10")
    private lateinit var positionedExposedMenuAdapter: PositionedExposedMenuAdapter
    private var selectedItemPosition = 0

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
        configureTopAppbarMenu()
        configurePositionedExposeDropdownMenu()

        binding.popUpMenuBtn.setOnClickListener {
            showMenu(it,R.menu.popup_menu)
        }
    }

    private fun configurePositionedExposeDropdownMenu(){
        binding.positionExposedAt.dropDownHeight = requireContext().dp(200)
        positionedExposedMenuAdapter = PositionedExposedMenuAdapter(requireContext(),R.layout.item_expose_dropdown_menu,items)
        binding.positionExposedAt.setAdapter(positionedExposedMenuAdapter)
        binding.positionExposedAt.setOnClickListener {
            // its remember selected item positions
            binding.positionExposedAt.listSelection = selectedItemPosition
            binding.positionExposedAt.showDropDown()
        }
        binding.positionExposedAt.setOnItemClickListener{ _, _, position, _ ->
            selectedItemPosition = position
        }
    }

    //showing popup menu
    private fun showMenu(anchor: View, @MenuRes menuRes: Int){
        val popup = PopupMenu(requireContext(), anchor)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_option_1 -> {
                    showToast("Option 1 selected")
                    true
                }
                R.id.action_option_2 -> {
                    showToast("Option 2 selected")
                    true
                }
                R.id.action_option_3 -> {
                    showToast("Option 3 selected")
                    true
                }
                else -> false
            }
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }
        popup.show()
    }
    private fun configureTopAppbar(){
        binding.incTopAppbar.topAppBar.title = "Menus"
        binding.incTopAppbar.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbar.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    //set menu on toolbar fragment owned toolbar
    private fun configureTopAppbarMenu(){
        binding.incTopAppbar.topAppBar.inflateMenu(R.menu.material_menu)
        binding.incTopAppbar.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_filter -> {
                    true
                }
                R.id.action_more -> {
                    true
                }
                else -> false
            }
        }
    }
}


internal class PositionedExposedMenuAdapter(
    private val context: Context,
    resource: Int,
    items: List<String>,
) : ArrayAdapter<String>(context,resource,items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemExposeDropdownMenuBinding

        val view: View
        if (convertView == null) {
            binding = ItemExposeDropdownMenuBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemExposeDropdownMenuBinding
        }

        val item = getItem(position)
        binding.itemTv.text = item
        return view
    }

}