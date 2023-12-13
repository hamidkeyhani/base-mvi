package com.fourplay.onboarding.presentation.splash.contract

sealed class SplashIntent {
    //    object GetSplash : SplashIntent()
//    object ContinueButtonClick : SplashIntent()
    object FinishDelay: SplashIntent()
    object CloseErrorDialog : SplashIntent()

}