package com.fourplay.common.extensions

fun String.toIntOrZero(): Int {
    return this.takeIf { it.isNotBlank() }?.toInt() ?: 0
}

fun String?.trimWhiteSpaces(): String {
    return this?.filter { !it.isWhitespace() } ?: this.orEmpty()
}