package com.iamkamrul.ui.extension

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings


fun Activity.navigateAppPermissionSettings(){
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    intent.data = Uri.fromParts("package",applicationContext.packageManager.getPackageInfo(applicationContext.packageName,0).packageName,null)
    startActivity(intent)
}