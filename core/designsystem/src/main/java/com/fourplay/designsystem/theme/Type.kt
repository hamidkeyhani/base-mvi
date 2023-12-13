package com.fourplay.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fourplay.designsystem.R

val TaraftarPlusFont = FontFamily(
    Font(R.font.brandon_bold, FontWeight.Bold),
    Font(R.font.brandon_regular, FontWeight.Normal),
    Font(R.font.brandon_light, FontWeight.Light),
    Font(R.font.brandon_thin, FontWeight.Thin),
)

val Typography.largeTitle: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        fontFamily = TaraftarPlusFont,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    )

val Typography.mediumTitle: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = TaraftarPlusFont,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
val Typography.smallTitle: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = TaraftarPlusFont,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )

val Typography.headLine: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = TaraftarPlusFont,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    )

val Typography.body: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = TaraftarPlusFont,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )

val Typography.callOut: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = TaraftarPlusFont,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )

val Typography.subHead: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = TaraftarPlusFont,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )

val Typography.footNote: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = TaraftarPlusFont,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )

val Typography.caption: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = TaraftarPlusFont,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    )

val Typography.buttonTypo: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = TaraftarPlusFont,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    )

internal val TaraftarPlusTypography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        fontFamily = TaraftarPlusFont,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    )
)