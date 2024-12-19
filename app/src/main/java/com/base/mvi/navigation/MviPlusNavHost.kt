package com.base.mvi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.base.onboarding.navigation.OnBoardingRoutesConstants
import com.base.onboarding.navigation.onBoardingGraph

@Composable
fun MviNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
//    startDestination: String = "HomeRoutesConstants.HOME_ROUTE",
    startDestination: String = OnBoardingRoutesConstants.SPLASH_SCREEN_ROUTE,
    onOpenReactNativeActivity: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        onBoardingGraph(
            changeTopAndBottomState = { _, _ -> },
            navController = navController,
            navigateToLogin = { },
            navigateToHome = { },
            onOpenReactNativeActivity = onOpenReactNativeActivity
        )

//        homeGraph(
//            changeTopAndBottomState = { _, _ -> },
//            navController = navController,
//            navigateToCampaign = navController::navigateToCampaign,
//            navigateToProjects = navController::navigateToProjects,
//            navigateToProjectDetails = navController::navigateToProjectDetails,
//            navigateToNotification = navController::navigateToNotification,
//            onNavigateToCampaignDetails = navController::navigateToCampaignDetails
//        )
    }
}
