package com.fourplay.designsystem.baseScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fourplay.designsystem.theme.TaraftarPlusTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasePreviewContainer(
    title: String = "PayCore",
    content: @Composable (PaddingValues) -> Unit,
) {
    TaraftarPlusTheme(darkTheme = false) {
        Scaffold(
//            topBar = { ScAppBar(title = title, onBackButtonClick = { }) },
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}