package com.iamkamrul.common.extension

import android.util.Base64

fun String.decode(): String =
     Base64.decode(this.replace(" ","/"), Base64.DEFAULT).toString(charset("UTF-8"))


fun String.encode(): String =
    Base64.encodeToString(this.toByteArray(charset("UTF-8")), Base64.DEFAULT).replace("/"," ")