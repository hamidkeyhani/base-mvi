package com.fourplay.taraftarplus.navigation

import androidx.annotation.DrawableRes
import com.fourplay.designsystem.R

enum class TopLevelDestination(
    @DrawableRes val selectedIconId: Int,
    @DrawableRes val unselectedIcon: Int,
) {
    HOME(
        unselectedIcon = R.drawable.ic_home,
        selectedIconId = R.drawable.ic_home_fill,
    ),
    SALES(
        unselectedIcon = R.drawable.ic_graph,
        selectedIconId = R.drawable.ic_graph_fill,
    ),
    WALLET(
        unselectedIcon = R.drawable.ic_wallet,
        selectedIconId = R.drawable.ic_wallet_fill,
    ),
    PROFILE(
        unselectedIcon = R.drawable.ic_user,
        selectedIconId = R.drawable.ic_user_fill,
    )
}
