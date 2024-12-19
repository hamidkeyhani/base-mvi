package com.base.mvi.navigation

import androidx.annotation.DrawableRes
import com.base.designsystem.R

enum class TopLevelDestination(
    @DrawableRes val selectedIconId: Int,
    @DrawableRes val unselectedIcon: Int,
) {
    HOME(
        unselectedIcon = R.drawable.baseline_5g_24,
        selectedIconId = R.drawable.baseline_5g_24,
    ),
    SALES(
        unselectedIcon = R.drawable.baseline_5g_24,
        selectedIconId = R.drawable.baseline_5g_24,
    ),
    WALLET(
        unselectedIcon = R.drawable.baseline_5g_24,
        selectedIconId = R.drawable.baseline_5g_24,
    ),
    PROFILE(
        unselectedIcon = R.drawable.baseline_5g_24,
        selectedIconId = R.drawable.baseline_5g_24,
    )
}
