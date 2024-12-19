package com.base.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.base.onboarding.presentation.splash.SplashRoute

fun NavGraphBuilder.onBoardingGraph(
    changeTopAndBottomState: (showTopBar: Boolean, showBottomNavigation: Boolean) -> Unit,
    navController: NavController,
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
    onOpenReactNativeActivity: () -> Unit
) {


    composable(route = OnBoardingRoutesConstants.SPLASH_SCREEN_ROUTE) {
        SplashRoute(
            onNavigateTo = navController::navigate,
            onNavigateUp = navController::navigateUp,
            onNavigateToOnBoarding = { },
            onNavigateToHome = navigateToHome,
            onOpenReactNativeActivity = onOpenReactNativeActivity
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