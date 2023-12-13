package com.fourplay.onboarding.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fourplay.common.extensions.collectAsStateWithLifecycle
import com.fourplay.common.extensions.collectWithLifecycle
import com.fourplay.designsystem.baseScreen.BasePreviewContainer
import com.fourplay.designsystem.baseScreen.BaseScreen
import com.fourplay.designsystem.baseScreen.ErrorStateConfig
import com.fourplay.designsystem.R
import com.fourplay.onboarding.navigation.OnBoardingRoutesConstants
import kotlinx.coroutines.flow.Flow
import com.fourplay.onboarding.presentation.splash.contract.SplashEvent
import com.fourplay.onboarding.presentation.splash.contract.SplashIntent
import com.fourplay.onboarding.presentation.splash.contract.SplashUiState

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
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HandleEvents(viewModel.event, onNavigateTo, onNavigateToOnBoarding, onNavigateUp)

    SplashScreen(
        uiState = uiState,
        onIntent = viewModel::acceptIntent,
        onNavigateUp = onNavigateUp
    )

}

@Composable
private fun SplashScreen(
    uiState: SplashUiState,
    onNavigateUp: () -> Unit,
    onIntent: (SplashIntent) -> Unit,
) = ScreenConfig(uiState, onNavigateUp, onIntent) {

    Image(
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.splash),
        contentDescription = null
    )

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
        onNavigateUp = {}
    )
}