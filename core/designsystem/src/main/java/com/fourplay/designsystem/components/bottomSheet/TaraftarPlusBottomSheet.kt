package com.fourplay.designsystem.components.bottomSheet

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaraftarPlusBottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    onBackClick: () -> Unit,
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 0.dp,
        modifier = modifier.fillMaxSize(),
        sheetGesturesEnabled = false,
        sheetContent = {
            BackHandler(enabled = true) {
                if (bottomSheetScaffoldState.bottomSheetState.isExpanded) {
                    scope.launch {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
                onBackClick()
            }
            sheetContent()
        },
        backgroundColor = MaterialTheme.colors.surface,
        sheetBackgroundColor = MaterialTheme.colors.background
    ) {
        content()
    }
}