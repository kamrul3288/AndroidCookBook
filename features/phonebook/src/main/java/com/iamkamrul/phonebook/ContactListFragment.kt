package com.iamkamrul.phonebook

import android.Manifest
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.iamkamrul.phonebook.databinding.FragmentContactListBinding
import com.iamkamrul.ui.base.BaseFragment
import com.iamkamrul.ui.extension.debounce
import com.iamkamrul.ui.extension.navigateAppPermissionSettings
import com.iamkamrul.ui.extension.popBack
import com.iamkamrul.ui.extension.setUpVerticalRecyclerViewAdapter
import com.iamkamrul.ui.extension.showAlertDialog
import timber.log.Timber


class ContactListFragment : BaseFragment<FragmentContactListBinding>() {
    override fun viewBindingLayout(): FragmentContactListBinding  = FragmentContactListBinding.inflate(layoutInflater)

    private lateinit var phoneBookAccessPermissionLauncher:ActivityResultLauncher<Array<String>>
    private val runtimePermissions = arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE)
    private val contactSections = mutableListOf<ContactItem>()
    private val adapter by lazy { ContactListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureActivityResult()
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        configureTopAppbar()
        requireContext().setUpVerticalRecyclerViewAdapter(binding.contactsRv,adapter)
        checkReadPhoneNumberPermission()

        binding.searchET.debounce(500L,lifecycleScope){ it ->
            val filterText = it.toString()
            if (filterText.isNotEmpty()){
               val result = contactSections.filter {
                   it.name.lowercase().contains(filterText.lowercase()) || it.phoneNumber.lowercase().contains(filterText.lowercase())
               }
                adapter.submitList(result)
           }else{
                adapter.submitList(contactSections)
           }
        }
    }

    private fun checkReadPhoneNumberPermission(){
        phoneBookAccessPermissionLauncher.launch(runtimePermissions)
    }

    private fun configureActivityResult(){
        phoneBookAccessPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ it ->
            it.entries.forEach {permissionResult->
                if (!permissionResult.value) {
                    if (!shouldShowRequestPermissionRationale(permissionResult.key)){
                        // Permission denied and "Never ask again" selected
                        showPermissionExplanationDialog()
                    }else{
                        // Permission denied but not "Never ask again" selected
                        checkReadPhoneNumberPermission()
                    }
                    return@registerForActivityResult
                }
            }
            // All permission granted
            fetchAllContactNumber()
        }
    }

    private fun showPermissionExplanationDialog(){
        requireContext().showAlertDialog(
            title = "Allow Call Permission",
            message = "To see your phone number. Please allow phone permission",
            positiveButtonText = "Settings"
        ){
            requireActivity().navigateAppPermissionSettings()
        }
    }


    private fun fetchAllContactNumber(){
        val cursor = requireContext().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null
        )
        val contacts = mutableListOf<Contact>()
        cursor?.use {
            val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val phoneNumberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            while (it.moveToNext()) {
                val phoneNumber = it.getString(phoneNumberIndex)
                val name = it.getString(nameIndex)
                contacts.add(Contact(name = name, phoneNumber = phoneNumber))
            }
        }


        val sortedContacts = contacts.sortedBy { it.name.first() }
        val contactsGroupedByFirstLetter = sortedContacts.groupBy { it.name.first().uppercase() }
        val sortedGroups = contactsGroupedByFirstLetter.toSortedMap()
        for ((letter, group) in sortedGroups) {
            contactSections.add(ContactItem(viewType = ContactViewType.section, sectionTitle = letter))
            group.forEach {
                contactSections.add(ContactItem(viewType = ContactViewType.items, phoneNumber = it.phoneNumber, name = it.name))
            }
        }
        adapter.submitList(contactSections)
    }



    private fun configureTopAppbar(){
        binding.incTopAppBar.topAppBar.title = "Contacts"
        binding.incTopAppBar.topAppBar.setNavigationIcon(R.drawable.ic_arrow_back_24)
        binding.incTopAppBar.topAppBar.setNavigationOnClickListener {
            popBack()
        }
    }

}