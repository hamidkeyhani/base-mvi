@file:OptIn(ExperimentalMaterialApi::class)

package com.fourplay.designsystem.baseScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fourplay.designsystem.components.appBar.AppBarConfig


@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(16.dp),
    isLoading: Boolean = false,
    isEmpty: Boolean = false,
    isError: Boolean = false,
    stickyButtonText: String? = null,
    isLoadingStickyButton:Boolean = false,
    stickyButtonClicked: (() -> Unit)? = null,
    enableStickyButton: Boolean = true,
    emptyStateConfig: EmptyStateConfig = EmptyStateConfig.DEFAULT,
    errorStateConfig: ErrorStateConfig = ErrorStateConfig.DEFAULT,
    appBarConfig: AppBarConfig? = null,
    content: @Composable () -> Unit,
) {
    if (isLoading) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        BaseContainer(
            modifier = modifier,
            padding = padding,
            appBarConfig = appBarConfig,
            stickyButtonClicked = stickyButtonClicked,
            stickyButtonText = stickyButtonText,
            enableStickyButton = enableStickyButton,
            isLoadingStickyButton = isLoadingStickyButton,
            content = content
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(16.dp),
    isLoading: Boolean = false,
    isEmpty: Boolean = false,
    isError: Boolean = false,
    stickyButtonText: String? = null,
    stickyButtonClicked: (() -> Unit)? = null,
    isLoadingStickyButton: Boolean = false,
    enableStickyButton: Boolean = true,
    emptyStateConfig: EmptyStateConfig = EmptyStateConfig.DEFAULT,
    errorStateConfig: ErrorStateConfig = ErrorStateConfig.DEFAULT,
    successStateConfig: ErrorStateConfig = ErrorStateConfig.DEFAULT,
    appBarConfig: AppBarConfig? = null,
    content: @Composable () -> Unit,
    bottomSheetConfig: BottomSheetConfig? = null,
) {

    if (isLoading) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        bottomSheetConfig?.let {
            BaseContainer(
                modifier = modifier,
                padding = padding,
                appBarConfig = appBarConfig,
                isLoadingStickyButton = isLoadingStickyButton,
                stickyButtonClicked = stickyButtonClicked,
                stickyButtonText = stickyButtonText,
                enableStickyButton = enableStickyButton,
                bottomSheetScaffoldState = bottomSheetConfig.bottomSheetScaffoldState,
                showBackground = bottomSheetConfig.showBackground,
                closeBottomSheet = bottomSheetConfig.onBackClick,
                sheetContent = bottomSheetConfig.sheetContent,
                content = content
            )
        }
    }


}
//    when {
//        isLoading -> FullScreenLoadingWithTitle(shown = true, title = R.string.loading)
//        isEmpty -> EmptyStateContent(config = emptyStateConfig)
//        isError -> ErrorStateContent(errorStateConfig)
//        buttonConfig != null -> BaseContainerWithStickyButton(
//            modifier,
//            padding,
//            buttonConfig,
//            stickyBtnType,
//            appBarConfig,
//            content
//        )
//        else -> BaseContainer(modifier, padding, appBarConfig, content)
//    }

//@Composable
//fun BottomSheetBaseScreen(
//    modifier: Modifier = Modifier,
//    padding: PaddingValues = PaddingValues(16.dp),
//    isLoading: Boolean = false,
//    isEmpty: Boolean = false,
//    isError: Boolean = false,
////    buttonConfig: ButtonConfig? = null,
//    emptyStateConfig: EmptyStateConfig = EmptyStateConfig.DEFAULT,
//    errorStateConfig: ErrorStateConfig = ErrorStateConfig.DEFAULT,
//    bottomSheetConfig: BottomSheetConfig? = null,
//    appBarConfig: AppBarConfig? = null,
//    content: @Composable () -> Unit
//) {
//
//    when {
//        isLoading -> FullScreenLoadingWithTitle(shown = true, title = R.string.loading)
//        isEmpty -> EmptyStateContent(config = emptyStateConfig)
//        isError -> ErrorStateContent(errorStateConfig)
//        bottomSheetConfig != null -> BaseContainerWithBottomSheet(
//            modifier = modifier,
//            padding = padding,
////            buttonConfig = buttonConfig,
////            bottomSheetScaffoldState = bottomSheetConfig.bottomSheetScaffoldState,
//            showBackground = bottomSheetConfig.showBackground,
//            closeBottomSheet = bottomSheetConfig.onBackClick,
//            sheetContent = bottomSheetConfig.sheetContent,
//            appBarConfig = appBarConfig,
//            content = content
//        )
//        else -> BaseContainer(modifier, padding, appBarConfig, content)
//    }
//}