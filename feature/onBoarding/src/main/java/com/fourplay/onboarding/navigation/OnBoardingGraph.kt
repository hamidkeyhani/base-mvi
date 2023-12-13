package com.fourplay.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fourplay.onboarding.presentation.splash.SplashRoute

fun NavGraphBuilder.onBoardingGraph(
    changeTopAndBottomState: (showTopBar: Boolean, showBottomNavigation: Boolean) -> Unit,
    navController: NavController,
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
) {


    composable(route = OnBoardingRoutesConstants.SPLASH_SCREEN_ROUTE) {
        SplashRoute(
            onNavigateTo = navController::navigate,
            onNavigateUp = navController::navigateUp,
            onNavigateToOnBoarding = { },
            onNavigateToHome = navigateToHome
        )
    }

//    composable(route = OnBoardingRoutesConstants.ON_BOARDING_ROUT) {
//        OnBoardingRoute(
//            onNavigateTo = navController::navigate,
//            onNavigateUp = navController::navigateUp,
//            onNavigateToLogin = navigateToLogin,
//            onNavigateToHome = navigateToHome
//        )
//    }


}