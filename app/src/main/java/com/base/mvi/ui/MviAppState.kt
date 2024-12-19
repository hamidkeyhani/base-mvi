package com.base.mvi.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.base.mvi.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberMviAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): MviAppState {
    return remember(navController, coroutineScope, windowSizeClass) {
        MviAppState(navController, coroutineScope, windowSizeClass)
    }
}

@Stable
class MviAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    private val windowSizeClass: WindowSizeClass,
//    networkMonitor: NetworkMonitor,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
//            HomeRoutesConstants.HOME_ROUTE -> TopLevelDestination.HOME
//            SalesRoutesConstants.salesPanelRoute -> TopLevelDestination.SALES
//            WalletRoutesConstants.walletRoute -> TopLevelDestination.WALLET
//            ProfileRoutesConstants.profileRoute -> TopLevelDestination.PROFILE
//            CampaignRoutesConstants.campaignRoute -> TopLevelDestination.HOME
//            ProjectsRoutesConstants.projectsRoute -> TopLevelDestination.HOME
//            ProjectsRoutesConstants.mapDetailsRoute -> TopLevelDestination.HOME
            else -> null
        }


    var shouldShowSettingsDialog by mutableStateOf(false)
        private set

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact ||
                windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact


    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

//        when (topLevelDestination) {
//            TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
//            TopLevelDestination.SALES -> navController.navigateToSalesPanel(topLevelNavOptions)
//            TopLevelDestination.PROFILE -> navController.navigateToProfile(topLevelNavOptions)
//            TopLevelDestination.WALLET -> navController.navigateToWallet(topLevelNavOptions)
//        }

    }

    fun onBackClick() {
        navController.popBackStack()
    }
}