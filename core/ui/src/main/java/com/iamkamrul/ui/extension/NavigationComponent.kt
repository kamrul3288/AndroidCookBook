package com.iamkamrul.ui.extension

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

fun Fragment.navigate(
    uri: Uri,
    popupToId:Int? = null,
    popupToInclusive:Boolean = false
){
    findNavController().navigate(
        NavDeepLinkRequest.Builder.fromUri(uri).build(),
        navOptions = navOptions {
            anim {

            }
            popupToId?.let {
                popUpTo(popupToId){
                    inclusive = popupToInclusive
                }
            }
        }
    )
}