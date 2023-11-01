package com.iamkamrul.phonebook


internal object ContactViewType{
    const val section = 0
    const val items = 1
}

data class ContactItem(
    val viewType:Int,
    val sectionTitle:String = "",
    val name:String = "",
    val phoneNumber:String = "",
)

internal data class Contact(
    val name:String,
    val phoneNumber:String
)
