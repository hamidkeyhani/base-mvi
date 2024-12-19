package com.base.designsystem.components.appBar

import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.material.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MviScaffold(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        contentColor = MaterialTheme.colorScheme.surface,
//        containerColor = MaterialTheme.colorScheme.surface,
        scaffoldState = scaffoldState,
        topBar = topBar,
        bottomBar = bottomBar,
    ) { padding ->
        content.invoke(padding)
    }
}