package com.base.designsystem.baseScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.base.designsystem.theme.MviTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasePreviewContainer(
    title: String = "PayCore",
    content: @Composable (PaddingValues) -> Unit,
) {
    MviTheme(darkTheme = false) {
        Scaffold(
//            topBar = { ScAppBar(title = title, onBackButtonClick = { }) },
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}