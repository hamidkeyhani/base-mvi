package com.base.designsystem.baseScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.base.designsystem.components.appBar.AppBarConfig
import com.base.designsystem.components.appBar.MviScaffold

@Composable
fun BaseContainerWithBottomSheet(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(0.dp),
//    buttonConfig: ButtonConfig?,
//    bottomSheetScaffoldState: BottomSheetScaffoldState,
    showBackground: Boolean,
    closeBottomSheet: () -> Unit,
    appBarConfig: AppBarConfig? = null,
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    MviScaffold(topBar = {
        appBarConfig?.apply {
//            ScAppBar(
//                title = appBarTitle,
//                titleIcon = titleIcon,
//                onBackButtonClick = onNavigateUp,
//                showBackButton = showBackButton,
//                trailingIcon = trailingIcon,
//                onTrailingClicked = onTrailingClicked,
//                trailingText = trailingText
//            )
        }
    }) {
//
//        ScBottomSheet(
//            bottomSheetScaffoldState = bottomSheetScaffoldState,
//            onBackClick = closeBottomSheet,
//            sheetContent = sheetContent
//        ) {
//            Box(modifier = Modifier.fillMaxSize()) {
//
//                Column(modifier.fillMaxSize()) {
//
//                    Box(
//                        modifier
//                            .weight(1F)
//                            .padding(padding)
//                    ) {
//                        content()
//                    }
//
//                    buttonConfig?.let {
//                        ScStickyButton(
//                            config = it
//                        )
//                    }
//                }
//
//                AnimatedVisibility(
//                    visible = showBackground,
//                    enter = fadeIn(
//                        initialAlpha = 0.3f,
//                        animationSpec = tween(
//                            durationMillis = 200
//                        )
//                    ),
//                    exit = fadeOut(
//                        animationSpec = tween(
//                            durationMillis = 400
//                        )
//                    )
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .clickable(
//                                interactionSource = MutableInteractionSource(),
//                                indication = null
//                            ) {
//                                closeBottomSheet.invoke()
//                            }
//                            .background(color = MaterialTheme.colors.onSecondary.copy(alpha = 0.9f))
//                    )
//                }
//            }
//
//        }

    }

}
