package com.iamkamrul.ui.extension

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.showAlertDialog(
    title:String,
    message:String,
    positiveButtonText:String,
    onPositiveButtonClick:()->Unit
){
    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(positiveButtonText){dialog,_->
            onPositiveButtonClick()
            dialog.dismiss()
        }
        .show()
}