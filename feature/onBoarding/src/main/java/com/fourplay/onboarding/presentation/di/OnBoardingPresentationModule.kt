package com.fourplay.onboarding.presentation.di

import com.fourplay.onboarding.presentation.splash.contract.SplashUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object OnBoardingPresentationModule {

    @Provides
    fun provideSplashUiState(): SplashUiState =
        SplashUiState()

}