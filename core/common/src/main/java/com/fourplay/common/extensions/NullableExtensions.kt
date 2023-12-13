package com.fourplay.common.extensions

import java.math.BigDecimal

fun Int?.orZero() = this ?: 0

fun BigDecimal?.orZero() = this ?: BigDecimal(0)

fun Double?.orZero() = this ?: 0.0

fun String?.orDash() = this ?: "-"