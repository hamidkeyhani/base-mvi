package com.fourplay.designsystem.theme

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

/**
 * Light default theme color scheme
 */

val ColorScheme.white: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) White else White
val ColorScheme.black: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Black else Black

//Primary
val ColorScheme.primary900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue900 else NavyBlue900
val ColorScheme.primary800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue800 else NavyBlue800
val ColorScheme.primary700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue700 else NavyBlue700
val ColorScheme.primary600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue600 else NavyBlue600
val ColorScheme.primary500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue500 else NavyBlue500
val ColorScheme.primary400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue400 else NavyBlue400
val ColorScheme.primary300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue300 else NavyBlue300
val ColorScheme.primary200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue200 else NavyBlue200
val ColorScheme.primary100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue100 else NavyBlue100
val ColorScheme.primary50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) NavyBlue50 else NavyBlue50


//Primary Blue
val ColorScheme.primaryBlue900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue900 else Blue900
val ColorScheme.primaryBlue800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue800 else Blue800
val ColorScheme.primaryBlue700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue700 else Blue700
val ColorScheme.primaryBlue600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue600 else Blue600
val ColorScheme.primaryBlue500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue500 else Blue500
val ColorScheme.primaryBlue400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue400 else Blue400
val ColorScheme.primaryBlue300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue300 else Blue300
val ColorScheme.primaryBlue200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue200 else Blue200
val ColorScheme.primaryBlue100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue100 else Blue100
val ColorScheme.primaryBlue50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue50 else Blue50


//Success
val ColorScheme.success900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green900 else Green900
val ColorScheme.success800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green800 else Green800
val ColorScheme.success700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green700 else Green700
val ColorScheme.success600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green600 else Green600
val ColorScheme.success500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green500 else Green500
val ColorScheme.success400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green400 else Green400
val ColorScheme.success300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green300 else Green300
val ColorScheme.success200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green200 else Green200
val ColorScheme.success100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green100 else Green100
val ColorScheme.success50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Green50 else Green50

//Success
val ColorScheme.error900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red900 else Red900
val ColorScheme.error800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red800 else Red800
val ColorScheme.error700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red700 else Red700
val ColorScheme.error600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red600 else Red600
val ColorScheme.error500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red500 else Red500
val ColorScheme.error400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red400 else Red400
val ColorScheme.error300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red300 else Red300
val ColorScheme.error200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red200 else Red200
val ColorScheme.error100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red100 else Red100
val ColorScheme.error50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Red50 else Red50

//Warning
val ColorScheme.warning900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow900 else Yellow900
val ColorScheme.warning800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow800 else Yellow800
val ColorScheme.warning700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow700 else Yellow700
val ColorScheme.warning600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow600 else Yellow600
val ColorScheme.warning500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow500 else Yellow500
val ColorScheme.warning400: Color
    @Composable
    @ReadOnlyComposable
    get() = if (!isSystemInDarkTheme()) Yellow400 else Yellow400
val ColorScheme.warning300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow300 else Yellow300
val ColorScheme.warning200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow200 else Yellow200
val ColorScheme.warning100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow100 else Yellow100
val ColorScheme.warning50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Yellow50 else Yellow50

//Modern blue
val ColorScheme.modernBlue900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue900 else ModernBlue900
val ColorScheme.modernBlue800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue800 else ModernBlue800
val ColorScheme.modernBlue700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue700 else ModernBlue700
val ColorScheme.modernBlue600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue600 else ModernBlue600
val ColorScheme.modernBlue500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue500 else ModernBlue500
val ColorScheme.modernBlue400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue400 else ModernBlue400
val ColorScheme.modernBlue300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue300 else ModernBlue300
val ColorScheme.modernBlue200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue200 else ModernBlue200
val ColorScheme.modernBlue100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue100 else ModernBlue100
val ColorScheme.modernBlue50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ModernBlue50 else ModernBlue50


//Gray
val ColorScheme.gray900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray900 else Gray900
val ColorScheme.gray800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray800 else Gray800
val ColorScheme.gray700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray700 else Gray700
val ColorScheme.gray600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray600 else Gray600
val ColorScheme.gray500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray500 else Gray500
val ColorScheme.gray400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray400 else Gray400
val ColorScheme.gray300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray300 else Gray300
val ColorScheme.gray200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray200 else Gray200
val ColorScheme.gray100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray100 else Gray100
val ColorScheme.gray50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray50 else Gray50
val ColorScheme.gray25: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Gray50 else Gray50


//Secondary
val ColorScheme.secondary900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue900 else CyanBlue900
val ColorScheme.secondary800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue800 else CyanBlue800
val ColorScheme.secondary700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue700 else CyanBlue700
val ColorScheme.secondary600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue600 else CyanBlue600
val ColorScheme.secondary500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue500 else CyanBlue500
val ColorScheme.secondary400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue400 else CyanBlue400
val ColorScheme.secondary300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue300 else CyanBlue300
val ColorScheme.secondary200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue200 else CyanBlue200
val ColorScheme.secondary100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue100 else CyanBlue100
val ColorScheme.secondary50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) CyanBlue50 else CyanBlue50


//Secondary
val ColorScheme.purple900: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple900 else Purple900
val ColorScheme.purple800: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple800 else Purple800
val ColorScheme.purple700: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple700 else Purple700
val ColorScheme.purple600: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple600 else Purple600
val ColorScheme.purple500: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple500 else Purple500
val ColorScheme.purple400: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple400 else Purple400
val ColorScheme.purple300: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple300 else Purple300
val ColorScheme.purple200: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple200 else Purple200
val ColorScheme.purple100: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple100 else Purple100
val ColorScheme.purple50: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple50 else Purple50


@VisibleForTesting
val LightColorScheme = lightColorScheme(
    primary = NavyBlue900,
    onPrimary = White,
    primaryContainer = NavyBlue500,
    onPrimaryContainer = White,
    secondary = Color.Black,
    onSecondary = White,
    secondaryContainer = CyanBlue500,
    onSecondaryContainer = White,
    tertiary = Blue900,
    onTertiary = White,
    tertiaryContainer = Blue500,
    onTertiaryContainer = White,
    error = Red500,
    onError = White,
//    errorContainer = Red90,
//    onErrorContainer = Red10,
//    background = DarkPurpleGray99,
//    onBackground = DarkPurpleGray10,
//    surface = DarkPurpleGray99,
//    onSurface = DarkPurpleGray10,
//    surfaceVariant = PurpleGray90,
//    onSurfaceVariant = PurpleGray30,
//    inverseSurface = DarkPurpleGray20,
//    inverseOnSurface = DarkPurpleGray95,
//    outline = PurpleGray50
)

@Composable
fun TaraftarPlusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    content: @Composable () -> Unit,
) = TaraftarPlusTheme(
    darkTheme = darkTheme,
    androidTheme = androidTheme,
    disableDynamicTheming = false,
    content = content
)

@Composable
internal fun TaraftarPlusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean,
    content: @Composable () -> Unit,
) {
    // Color scheme
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = TaraftarPlusTypography,
        content = content
    )
}