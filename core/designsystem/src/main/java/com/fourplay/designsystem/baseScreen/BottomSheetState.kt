@file:OptIn(ExperimentalMaterialApi::class)

package com.fourplay.designsystem.baseScreen

import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

data class BottomSheetConfig constructor(
    val bottomSheetScaffoldState: BottomSheetScaffoldState,
    val showBackground: Boolean = false,
    val onBackClick: () -> Unit,
    val sheetContent: @Composable () -> Unit
)
