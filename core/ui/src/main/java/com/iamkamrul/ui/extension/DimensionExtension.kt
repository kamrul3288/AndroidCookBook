package com.iamkamrul.ui.extension

import android.content.Context

fun Context.dp(value:Int):Int{
    val dpRatio: Float = resources.displayMetrics.density
    return (value * dpRatio).toInt()
}
