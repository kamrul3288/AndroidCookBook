package com.iamkamrul.ui.extension

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.iamkamrul.ui.R

fun Fragment.navigate(
    uri: Uri,
    popupToId:Int? = null,
    popupToInclusive:Boolean = false
){
    findNavController().navigate(
        NavDeepLinkRequest.Builder.fromUri(uri).build(),
        navOptions = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
            popupToId?.let {
                popUpTo(popupToId){
                    inclusive = popupToInclusive
                }
            }
        }
    )
}

fun Fragment.popBack(){
    findNavController().popBackStack()
}

fun Fragment.navigate(direction: NavDirections) {
    val currentNode = (
            if (findNavController().currentBackStack.value.isEmpty()) findNavController().graph
            else findNavController().currentBackStack.value.last().destination
            )
    val navAction = currentNode.getAction(direction.actionId)
    findNavController().navigate(
        direction.actionId,
        direction.arguments,
        navAction?.navOptions?.let {
            navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
                popUpTo(it.popUpToId){
                    inclusive = it.isPopUpToInclusive()
                }

            }
        }

    )
}