package com.base.onboarding.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.base.common.extensions.collectAsStateWithLifecycle
import com.base.common.extensions.collectWithLifecycle
import com.base.designsystem.baseScreen.BasePreviewContainer
import com.base.designsystem.baseScreen.BaseScreen
import com.base.designsystem.baseScreen.ErrorStateConfig
import com.base.onboarding.navigation.OnBoardingRoutesConstants
import kotlinx.coroutines.flow.Flow
import com.base.onboarding.presentation.splash.contract.SplashEvent
import com.base.onboarding.presentation.splash.contract.SplashIntent
import com.base.onboarding.presentation.splash.contract.SplashUiState

@Composable
private fun ScreenConfig(
    uiState: SplashUiState,
    onNavigateUp: () -> Unit,
    onIntent: (SplashIntent) -> Unit,
    content: @Composable () -> Unit,
) = BaseScreen(
    isLoading = uiState.isLoading,
    isError = uiState.isError,
    padding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
    errorStateConfig = ErrorStateConfig(
        description = uiState.errorMessage,
        onButtonClicked = { onIntent.invoke(SplashIntent.CloseErrorDialog) }),
    content = content
)


@Composable
fun SplashRoute(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateTo: (route: String) -> Unit,
    onNavigateUp: () -> Unit,
    onNavigateToOnBoarding: () -> Unit,
    onNavigateToHome: () -> Unit,
    onOpenReactNativeActivity: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HandleEvents(viewModel.event, onNavigateTo, onNavigateToOnBoarding, onNavigateUp)

    SplashScreen(
        uiState = uiState,
        onIntent = viewModel::acceptIntent,
        onNavigateUp = onNavigateUp,
        onOpenReactNativeActivity = onOpenReactNativeActivity
    )

}

@Composable
private fun SplashScreen(
    uiState: SplashUiState,
    onNavigateUp: () -> Unit,
    onIntent: (SplashIntent) -> Unit,
    onOpenReactNativeActivity: () -> Unit
) = ScreenConfig(uiState, onNavigateUp, onIntent) {

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .background(shape = RoundedCornerShape(12.dp), color = Color.DarkGray)
                .padding(16.dp)
                .clickable { onOpenReactNativeActivity.invoke() },
            text = "Open React Native Module",
            color = Color.White
        )
    }


}

@Composable
fun HandleEvents(
    events: Flow<SplashEvent>,
    onNavigateTo: (route: String) -> Unit,
    onNavigateToOnBoarding: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    events.collectWithLifecycle {
        when (it) {
            is SplashEvent.NavigateTo -> if (it.route == OnBoardingRoutesConstants.ON_BOARDING_ROUT) onNavigateToOnBoarding() else onNavigateTo(
                it.route
            )

            is SplashEvent.NavigateUp -> onNavigateUp()
        }
    }
}


@Preview
@Composable
fun SplashPreview() = BasePreviewContainer {
    SplashScreen(
        uiState = SplashUiState(),
        onIntent = {},
        onNavigateUp = {},
        onOpenReactNativeActivity = {}
    )
}