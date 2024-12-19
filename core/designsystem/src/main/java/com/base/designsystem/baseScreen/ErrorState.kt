package com.base.designsystem.baseScreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
//import com.base.designsystem.components.button.baseButton.PayCoreButtons
//import com.base.designsystem.components.button.baseButton.SimpleButton
import com.base.designsystem.components.spacer.HeightSpacer
import com.base.designsystem.R

data class ErrorStateConfig(
    @StringRes val title: Int = R.string.AnErrorOccurred,
    val description: String = "",
    @DrawableRes val image: Int = androidx.core.R.drawable.notification_bg,
    @StringRes val buttonText: Int = R.string.TryAgain,
    val onButtonClicked: () -> Unit = {},
) {
    companion object {
        val DEFAULT = ErrorStateConfig()
    }
}

@Composable
fun ErrorStateContent(config: ErrorStateConfig) {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f)
                )
        ) {
            Card(
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(
                        horizontal = 16.dp
                    ).background(color =MaterialTheme.colorScheme.background )
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeightSpacer(value = 24)

                    Text(
                        text = stringResource(config.title),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 32.dp),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )

                    HeightSpacer(value = 32)

                    Image(
                        painter = painterResource(config.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                    )

                    HeightSpacer(value = 32)

                    Text(
                        text = config.description,
                        modifier = Modifier
                            .padding(horizontal = 32.dp),
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    HeightSpacer(value = 32)

//                    PayCoreButtons.SimpleButton(
//                        decoration = ButtonStyles.whiteStrokeButtonStyle(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(
//                                    horizontal = 32.dp
//                                )
//                        ),
//                        onClick = config.onButtonClicked,
//                        content = {
//                            Text(
//                                text = stringResource(config.buttonText),
//                                style = MaterialTheme.typography.labelMedium
//                            )
//                        },
//                    )

                    HeightSpacer(value = 32)

                }
            }
        }
    }
}
