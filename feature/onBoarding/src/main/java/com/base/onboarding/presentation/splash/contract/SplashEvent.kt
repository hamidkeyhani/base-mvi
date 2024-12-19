package com.base.onboarding.presentation.splash.contract


sealed class SplashEvent {
    data class NavigateTo(val route: String) : SplashEvent()
    object NavigateUp : SplashEvent()
}