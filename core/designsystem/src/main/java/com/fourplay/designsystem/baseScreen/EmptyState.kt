package com.fourplay.designsystem.baseScreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fourplay.designsystem.components.spacer.HeightSpacer

data class EmptyStateConfig(
    val imageModifier: Modifier = Modifier,
    @StringRes val title: Int? = null,
    @StringRes val description: Int? = null,
    val descriptionAlignment: TextAlign = TextAlign.Start,
    @DrawableRes val image: Int = androidx.core.R.drawable.notification_bg,
//    val positiveButtonConfig: ButtonConfig? = null,
//    val negativeButtonConfig: ButtonConfig? = null,
    val titlePadding: PaddingValues = PaddingValues(horizontal = 32.dp),
    val descriptionPadding: PaddingValues = PaddingValues(horizontal = 24.dp),
    val buttonPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
) {
    companion object {
        val DEFAULT = EmptyStateConfig()
    }
}

@Composable
fun EmptyStateContent(modifier: Modifier = Modifier, config: EmptyStateConfig) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeightSpacer(value = 24)

//        if (config.title != null) {
//            Text(
//                text = stringResource(config.title).parseHtml(),
//                style = MaterialTheme.typography.h6.copy(
//                    fontWeight = FontWeight.Medium,
//                    color = MaterialTheme.colors.onBackground
//                ),
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(config.titlePadding)
//            )
//        }

        HeightSpacer(value = 16)

        Image(
            painter = painterResource(id = config.image),
            contentDescription = null,
            modifier = config.imageModifier
        )

        HeightSpacer(value = 16)

//        Text(
//            text = stringResource(
//                config.description ?: UiR.string.unknown_error
//            ).parseHtml(),
//            style = MaterialTheme.typography.button.copy(
//                fontWeight = FontWeight.Normal,
//                color = MaterialTheme.colors.onSecondary
//            ),
//            textAlign = config.descriptionAlignment,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(config.descriptionPadding)
//        )

        HeightSpacer(value = 32)

//        if (config.positiveButtonConfig != null) {
//            PayCoreButtons.SimpleButton(
//                decoration = ButtonStyles.greenButtonStyle(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(config.buttonPadding)
//                ),
//                onClick = {
//                    config.positiveButtonConfig.onClicked.invoke()
//                },
//                enabled = true,
//                content = {
//                    Text(
//                        text = config.positiveButtonConfig.text,
//                        style = MaterialTheme.typography.button.copy(
//                            fontWeight = FontWeight.Medium
//                        )
//                    )
//                },
//            )
//        }

//        if (config.negativeButtonConfig != null) {
            HeightSpacer(value = 16)

//            PayCoreButtons.SimpleButton(
//                decoration = ButtonStyles.whiteStrokeButtonStyle(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(config.buttonPadding)
//                ),
//                onClick = {
//                    config.negativeButtonConfig.onClicked.invoke()
//                },
//                enabled = true,
//                content = {
//                    Text(
//                        text = config.negativeButtonConfig.text,
//                        style = MaterialTheme.typography.button.copy(
//                            fontWeight = FontWeight.Medium
//                        )
//                    )
//                },
//            )
//        }
    }
}
