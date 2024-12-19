package com.base.onboarding.navigation

import androidx.navigation.NavController

fun NavController.navigateToOnBoarding() {
    navigate(OnBoardingRoutesConstants.ON_BOARDING_ROUT) {
        popUpTo(OnBoardingRoutesConstants.SPLASH_SCREEN_ROUTE) {
            inclusive = true
        }
    }
}