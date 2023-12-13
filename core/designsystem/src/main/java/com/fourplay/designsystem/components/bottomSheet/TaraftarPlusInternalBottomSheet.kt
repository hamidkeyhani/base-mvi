package com.fourplay.designsystem.components.bottomSheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fourplay.designsystem.theme.primary50
import com.fourplay.designsystem.theme.primary900
import com.fourplay.designsystem.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaraftarPlusInternalBottomSheet(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp),
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    onDismiss: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        containerColor = MaterialTheme.colorScheme.white,
        contentColor = MaterialTheme.colorScheme.primary900,
        scrimColor = MaterialTheme.colorScheme.primary900.copy(alpha = 0.9f),
        sheetState = sheetState,
        dragHandle = { DragHandle() }
    ) {
        Column(
            modifier = modifier
                .padding(padding)
                .navigationBarsPadding(),
            horizontalAlignment = horizontalAlignment
        ) {
            content()
        }
    }
}

@Composable
fun DragHandle(
    modifier: Modifier = Modifier,
    width: Dp = 60.dp,
    height: Dp = 4.0.dp,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    color: Color = MaterialTheme.colorScheme.primary50,
) {
    Surface(
        modifier = modifier
            .padding(top = 24.dp, bottom = 20.dp)
            .semantics { contentDescription = "Drag handle" },
        color = color.copy(0.4f),
        shape = shape
    ) {
        Box(
            Modifier
                .size(
                    width = width,
                    height = height
                )
        )
    }
}