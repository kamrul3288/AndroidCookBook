package com.iamkamrul.material

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.iamkamrul.material.databinding.FragmentMenuBinding
import com.iamkamrul.material.databinding.ItemExposeDropdownMenuBinding
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.dp

class MenuFragment : BaseFragment<FragmentMenuBinding>(){
    override fun viewBindingLayout() = FragmentMenuBinding.inflate(layoutInflater)

    private val items = listOf("Item - 1", "Item - 2","Item - 3","Item - 4","Item - 5","Item - 6","Item - 7","Item - 8","Item - 9","Item - 10")
    private lateinit var positionedExposedMenuAdapter: PositionedExposedMenuAdapter
    private var selectedItemPosition = 0

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
        configurePositionedExposeDropdownMenu()
    }

    private fun configurePositionedExposeDropdownMenu(){
        binding.positionExposedAt.dropDownHeight = requireContext().dp(200)
        positionedExposedMenuAdapter = PositionedExposedMenuAdapter(requireContext(),R.layout.item_expose_dropdown_menu,items)
        binding.positionExposedAt.setAdapter(positionedExposedMenuAdapter)
        binding.positionExposedAt.setOnClickListener {
            binding.positionExposedAt.listSelection = selectedItemPosition
            binding.positionExposedAt.showDropDown()
        }
        binding.positionExposedAt.setOnItemClickListener{ _, _, position, _ ->
            selectedItemPosition = position
        }
    }

    private fun configureTopAppbar(){
        binding.incTopAppbar.topAppBar.title = "Menus"
        binding.incTopAppbar.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppbar.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
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