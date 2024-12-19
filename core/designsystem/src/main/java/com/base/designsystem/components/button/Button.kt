package com.base.designsystem.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.base.designsystem.R
import com.base.designsystem.components.spacer.WidthSpacer
import com.base.designsystem.theme.buttonTypo
import com.base.designsystem.theme.gray400
import com.base.designsystem.theme.gray500
import com.base.designsystem.theme.modernBlue50
import com.base.designsystem.theme.primary900
import com.base.designsystem.theme.primaryBlue500
import com.base.designsystem.theme.white

//New Buttons
@Composable
fun MviPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = MviButtonDefaults.contentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = MviButtonDefaults.buttonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.white,
            disabledContainerColor = MaterialTheme.colorScheme.modernBlue50,
            disabledContentColor = MaterialTheme.colorScheme.primary900
        ),
        contentPadding = contentPadding,
        content = content
    )
}


@Composable
fun MviPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    MviPrimaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            MviButtonDefaults.buttonWithIconContentPadding
        } else {
            MviButtonDefaults.contentPadding
        }
    ) {
        if (isLoading)
            CircularProgressIndicator(
                modifier = Modifier
                    .size(20.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.white,
            )
        else {
            MviButtonContent(
                text = text,
                leadingIcon = leadingIcon
            )
        }
    }
}

@Composable
fun MviPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
    @DrawableRes leadingIconId: Int? = null,
) {
    MviPrimaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        isLoading = isLoading,
        text = { MviButtonText(text, textStyle) },
        leadingIcon = iconComponentWithIconId(leadingIconId)
    )
}


@Composable
fun MviSmallPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    MviPrimaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = MviButtonDefaults.smallButtonContentPadding
    ) {
        MviButtonContent(
            text = text,
        )
    }
}


@Composable
fun MviSmallPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    MviSmallPrimaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        MviButtonText(text = text, textStyle = textStyle)
    }
}

@Composable
fun MviSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = MviButtonDefaults.contentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = MviButtonDefaults.buttonShape,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(
            width = MviButtonDefaults.OutlinedButtonBorderWidth,
            color = if (enabled) {
                MaterialTheme.colorScheme.outline
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = MviButtonDefaults.DISABLED_OUTLINED_BUTTON_BORDER_ALPHA
                )
            }
        ),
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun MviSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    MviSecondaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            MviButtonDefaults.buttonWithIconContentPadding
        } else {
            MviButtonDefaults.contentPadding
        }
    ) {
        MviButtonContent(
            text = text,
            leadingIcon = leadingIcon
        )
    }
}


@Composable
fun MviSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
    @DrawableRes leadingIconId: Int? = null,
) {
    MviSecondaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        text = { MviButtonText(text = text, textStyle = textStyle) },
        leadingIcon = iconComponentWithIconId(leadingIconId)
    )
}


@Composable
fun MviSmallSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    MviSecondaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = MviButtonDefaults.smallButtonContentPadding
    ) {
        MviButtonContent(
            text = text,
        )
    }
}

@Composable
fun MviSmallSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    MviSmallSecondaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        MviButtonText(text, textStyle = textStyle)
    }
}

@Composable
fun MviSmallSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.primary900,
    iconColor: Color = MaterialTheme.colorScheme.primary900,
    @DrawableRes leadingIconId: Int,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    MviSmallSecondaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(leadingIconId),
                contentDescription = null,
                colorFilter = ColorFilter.tint(iconColor),
                modifier = Modifier.size(19.dp)
            )
            WidthSpacer(value = 10)
            Text(text = text, style = textStyle, color = textColor)
        }
    }
}

@Preview
@Composable
fun MviSmallSecondaryButton() {
    MviSmallSecondaryButton(
        onClick = {},
        modifier = Modifier,
        enabled = true,
        text = "Button",
        leadingIconId = R.drawable.baseline_5g_24
    )
}

@Composable
fun MviTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.gray500,
        disabledContentColor = MaterialTheme.colorScheme.gray400
    ),
    contentPadding: PaddingValues = MviButtonDefaults.contentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = MviButtonDefaults.buttonShape,
        contentPadding = contentPadding,
        colors = colors,
        content = content
    )
}

@Composable
fun MviTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.gray500,
        disabledContentColor = MaterialTheme.colorScheme.gray400
    ),
    contentPadding: PaddingValues = MviButtonDefaults.contentPadding,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    MviTextButton(
        onClick = onClick,
        contentPadding = contentPadding,
        colors = colors,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled
    ) {
        MviButtonContent(
            text = text,
            leadingIcon = leadingIcon
        )
    }
}

@Composable
fun MviTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.primaryBlue500,
    ),
    text: String,
    @DrawableRes leadingIconId: Int? = null,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    MviTextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        contentPadding = MviButtonDefaults.contentPadding,
        colors = colors,
        enabled = enabled,
        text = {
            MviButtonText(
                text = text,
                textStyle = textStyle.copy(fontWeight = FontWeight.Bold)
            )
        },
        leadingIcon = iconComponentWithIconId(leadingIconId)
    )
}


@Composable
fun MviSmallTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.primaryBlue500,
    ),
    padding: PaddingValues = MviButtonDefaults.smallButtonContentPadding,
    text: @Composable () -> Unit,
) {
    MviTextButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        contentPadding = padding,
        enabled = enabled
    ) {
        MviButtonContent(
            text = text,
        )
    }
}

@Composable
fun MviSmallTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.primaryBlue500,
    ),
    padding: PaddingValues = MviButtonDefaults.smallButtonContentPadding,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    MviSmallTextButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        padding = padding,
        enabled = enabled
    ) {
        MviButtonText(text = text, textStyle = textStyle)
    }
}


@Composable
private fun iconComponentWithIconId(leadingIconId: Int?): @Composable (() -> Unit)? {
    return if (leadingIconId != null) {
        {
            Image(
                painter = painterResource(leadingIconId),
                contentDescription = null
            )
        }
    } else null
}

@Composable
private fun MviButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                }
            )
    ) {
        text()
    }
}

@Composable
private fun MviButtonText(text: String, textStyle: TextStyle) {
    Text(text = text, style = textStyle)
}

object MviButtonDefaults {
    const val DISABLED_OUTLINED_BUTTON_BORDER_ALPHA = 0.12f
    val OutlinedButtonBorderWidth = 1.dp
    val buttonShape = RoundedCornerShape(10.dp)
    private val verticalPadding = 19.dp
    private val buttonWithIconVerticalPadding = 10.dp
    private val horizontalPadding = 48.dp
    private val smallButtonVerticalPadding = 14.dp
    private val smallButtonHorizontalPadding = 8.dp
    val buttonWithIconContentPadding =
        PaddingValues(
            start = buttonWithIconVerticalPadding,
            top = verticalPadding,
            end = horizontalPadding,
            bottom = verticalPadding
        )
    val contentPadding =
        PaddingValues(
            start = horizontalPadding,
            top = verticalPadding,
            end = horizontalPadding,
            bottom = verticalPadding
        )
    val smallButtonContentPadding =
        PaddingValues(
            start = smallButtonHorizontalPadding,
            top = smallButtonVerticalPadding,
            end = smallButtonHorizontalPadding,
            bottom = smallButtonVerticalPadding
        )
}

@Preview
@Composable
fun MviPrimaryButtonPreview() {
    MviPrimaryButton(onClick = {}, text = "Button", isLoading = false)
}

@Preview
@Composable
fun MviPrimaryButtonLoadingModePreview() {
    MviPrimaryButton(onClick = {}, text = "Button", isLoading = true)
}
