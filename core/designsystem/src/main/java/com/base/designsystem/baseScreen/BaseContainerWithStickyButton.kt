package com.base.designsystem.baseScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.base.designsystem.components.appBar.AppBarConfig
import com.base.designsystem.components.appBar.MviScaffold

@Composable
fun BaseContainerWithStickyButton(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(0.dp),
//    config: ButtonConfig?,
//    stickyBtnType: StickyButtonType = StickyButtonType.Positive,
    appBarConfig: AppBarConfig? = null,
    content: @Composable () -> Unit
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

        Column(modifier.fillMaxSize()) {

            Box(
                modifier
                    .weight(1F)
                    .padding(padding)
            ) {
                content()
            }
//
//            config?.let {
//                ScStickyButton(
//                    type = stickyBtnType,
//                    config = it
//                )
//            }
        }

    }
}
