@file:OptIn(ExperimentalMaterialApi::class)

package com.base.designsystem.baseScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.base.designsystem.components.appBar.AppBarConfig
import com.base.designsystem.components.appBar.MviAppBar
import com.base.designsystem.components.appBar.MviScaffold
import com.base.designsystem.components.bottomSheet.MviBottomSheet
import com.base.designsystem.components.button.MviPrimaryButton
import com.base.designsystem.theme.gray200
import com.base.designsystem.theme.gray25
import com.base.designsystem.theme.white
import com.base.designsystem.utils.topBorder

@Composable
fun BaseContainer(
    modifier: Modifier,
    padding: PaddingValues,
    stickyButtonText: String? = null,
    stickyButtonClicked: (() -> Unit)? = null,
    enableStickyButton: Boolean,
    isLoadingStickyButton: Boolean,
    appBarConfig: AppBarConfig? = null,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.gray25)
    ) {
        appBarConfig?.apply {
            MviAppBar(appBarConfig = appBarConfig)
        }
        Box(
            modifier
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.gray25)
                .padding(padding)
        ) {
            content()
        }

        if (stickyButtonText != null && stickyButtonClicked != null) {
            MviStickyButton(
                stickyButtonText,
                stickyButtonClicked,
                enableStickyButton,
                isLoadingStickyButton
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BaseContainer(
    modifier: Modifier,
    padding: PaddingValues,
    stickyButtonText: String? = null,
    stickyButtonClicked: (() -> Unit)? = null,
    enableStickyButton: Boolean,
    isLoadingStickyButton: Boolean = false,
    appBarConfig: AppBarConfig? = null,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    showBackground: Boolean,
    closeBottomSheet: () -> Unit,
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Column {
        appBarConfig?.apply {
            MviAppBar(appBarConfig = appBarConfig)
        }
        Box(
            modifier
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.gray25)
                .padding(padding)
        ) {
            content()
        }

        if (stickyButtonText != null && stickyButtonClicked != null) {
            MviStickyButton(
                stickyButtonText,
                stickyButtonClicked,
                enableStickyButton,
                isLoadingStickyButton
            )
        }
    }

    MviScaffold(topBar = {
        appBarConfig?.apply {
            MviAppBar(appBarConfig = appBarConfig)
        }
    }) {

        MviBottomSheet(
            bottomSheetScaffoldState = bottomSheetScaffoldState,
            onBackClick = closeBottomSheet,
            sheetContent = sheetContent
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Column(modifier.fillMaxSize()) {

                    Box(
                        modifier
                            .weight(1F)
                            .padding(padding)
                    ) {
                        content()
                    }

                    if (stickyButtonText != null && stickyButtonClicked != null) {
                        MviStickyButton(
                            stickyButtonText,
                            stickyButtonClicked,
                            enableStickyButton,
                            isLoadingStickyButton
                        )
                    }
                }

                AnimatedVisibility(
                    visible = showBackground,
                    enter = fadeIn(
                        initialAlpha = 0.3f,
                        animationSpec = tween(
                            durationMillis = 200
                        )
                    ),
                    exit = fadeOut(
                        animationSpec = tween(
                            durationMillis = 400
                        )
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = null
                            ) {
                                closeBottomSheet.invoke()
                            }
                            .background(color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.9f))
                    )
                }
            }

        }

    }

}

@Composable
fun MviStickyButton(
    stickyButtonText: String,
    stickyButtonClicked: (() -> Unit),
    enableStickyButton: Boolean,
    isLoading: Boolean,
) {
    Box(
        modifier = Modifier
            .topBorder(1.dp, color = MaterialTheme.colorScheme.gray200)

            .background(color = MaterialTheme.colorScheme.white)
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        MviPrimaryButton(
            text = stickyButtonText,
            enabled = enableStickyButton,
            isLoading = isLoading,
            onClick = {
                stickyButtonClicked()
            })
    }
}