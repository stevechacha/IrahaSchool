package com.schooliraha.irahaschool.util

import java.util.*

fun String.titleCase():String = this.replaceFirstChar {
    if (it.isLowerCase()) {
        it.titlecase(Locale.getDefault())
    } else {
        it.toString()
    }
}