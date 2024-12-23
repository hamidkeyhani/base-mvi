package com.base.mvi.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.base.mvi.navigation.TopLevelDestination
import com.base.designsystem.components.navigation.MviNavigationBarItem
import com.base.designsystem.components.navigation.MviNavigationBar
import com.base.mvi.navigation.MviNavHost

@OptIn(
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
fun MviApp(
    appState: MviAppState,
    onOpenReactNativeActivity: () -> Unit
) {

    // TODO: it isn't good way for hide/show bottom navigation
    val shouldShowBottomSheet =
        (appState.currentTopLevelDestination == TopLevelDestination.HOME ||
                appState.currentTopLevelDestination == TopLevelDestination.PROFILE ||
                appState.currentTopLevelDestination == TopLevelDestination.WALLET ||
                appState.currentTopLevelDestination == TopLevelDestination.SALES)

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { padding ->
        Box {

            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                MviNavHost(
                    navController = appState.navController,
                    onBackClick = appState::onBackClick,
                    onOpenReactNativeActivity = onOpenReactNativeActivity
                )
            }

            if (appState.shouldShowBottomBar && shouldShowBottomSheet) {
                MviBottomBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                )
            }

        }

    }
}


@Composable
private fun MviBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    MviNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            MviNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                selectedIcon = destination.selectedIconId,
                icon = destination.unselectedIcon
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
