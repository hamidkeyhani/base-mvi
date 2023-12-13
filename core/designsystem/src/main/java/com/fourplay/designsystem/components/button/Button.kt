package com.fourplay.designsystem.components.button

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
import com.fourplay.designsystem.R
import com.fourplay.designsystem.components.spacer.WidthSpacer
import com.fourplay.designsystem.theme.buttonTypo
import com.fourplay.designsystem.theme.gray400
import com.fourplay.designsystem.theme.gray500
import com.fourplay.designsystem.theme.modernBlue50
import com.fourplay.designsystem.theme.primary900
import com.fourplay.designsystem.theme.primaryBlue500
import com.fourplay.designsystem.theme.white

//New Buttons
@Composable
fun TaraftarPlusPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = TaraftarPlusButtonDefaults.contentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = TaraftarPlusButtonDefaults.buttonShape,
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
fun TaraftarPlusPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    TaraftarPlusPrimaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            TaraftarPlusButtonDefaults.buttonWithIconContentPadding
        } else {
            TaraftarPlusButtonDefaults.contentPadding
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
            TaraftarPlusButtonContent(
                text = text,
                leadingIcon = leadingIcon
            )
        }
    }
}

@Composable
fun TaraftarPlusPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
    @DrawableRes leadingIconId: Int? = null,
) {
    TaraftarPlusPrimaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        isLoading = isLoading,
        text = { TaraftarPlusButtonText(text, textStyle) },
        leadingIcon = iconComponentWithIconId(leadingIconId)
    )
}


@Composable
fun TaraftarPlusSmallPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    TaraftarPlusPrimaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = TaraftarPlusButtonDefaults.smallButtonContentPadding
    ) {
        TaraftarPlusButtonContent(
            text = text,
        )
    }
}


@Composable
fun TaraftarPlusSmallPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    TaraftarPlusSmallPrimaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        TaraftarPlusButtonText(text = text, textStyle = textStyle)
    }
}

@Composable
fun TaraftarPlusSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = TaraftarPlusButtonDefaults.contentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = TaraftarPlusButtonDefaults.buttonShape,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(
            width = TaraftarPlusButtonDefaults.OutlinedButtonBorderWidth,
            color = if (enabled) {
                MaterialTheme.colorScheme.outline
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = TaraftarPlusButtonDefaults.DisabledOutlinedButtonBorderAlpha
                )
            }
        ),
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun TaraftarPlusSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    TaraftarPlusSecondaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            TaraftarPlusButtonDefaults.buttonWithIconContentPadding
        } else {
            TaraftarPlusButtonDefaults.contentPadding
        }
    ) {
        TaraftarPlusButtonContent(
            text = text,
            leadingIcon = leadingIcon
        )
    }
}


@Composable
fun TaraftarPlusSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
    @DrawableRes leadingIconId: Int? = null,
) {
    TaraftarPlusSecondaryButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        text = { TaraftarPlusButtonText(text = text, textStyle = textStyle) },
        leadingIcon = iconComponentWithIconId(leadingIconId)
    )
}


@Composable
fun TaraftarPlusSmallSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    TaraftarPlusSecondaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = TaraftarPlusButtonDefaults.smallButtonContentPadding
    ) {
        TaraftarPlusButtonContent(
            text = text,
        )
    }
}

@Composable
fun TaraftarPlusSmallSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    TaraftarPlusSmallSecondaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        TaraftarPlusButtonText(text, textStyle = textStyle)
    }
}

@Composable
fun TaraftarPlusSmallSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.primary900,
    iconColor: Color = MaterialTheme.colorScheme.primary900,
    @DrawableRes leadingIconId: Int,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    TaraftarPlusSmallSecondaryButton(
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
fun TaraftarPlusSmallSecondaryButton() {
    TaraftarPlusSmallSecondaryButton(
        onClick = {},
        modifier = Modifier,
        enabled = true,
        text = "Button",
        leadingIconId = R.drawable.ic_barricade
    )
}

@Composable
fun TaraftarPlusTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.gray500,
        disabledContentColor = MaterialTheme.colorScheme.gray400
    ),
    contentPadding: PaddingValues = TaraftarPlusButtonDefaults.contentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = TaraftarPlusButtonDefaults.buttonShape,
        contentPadding = contentPadding,
        colors = colors,
        content = content
    )
}

@Composable
fun TaraftarPlusTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.gray500,
        disabledContentColor = MaterialTheme.colorScheme.gray400
    ),
    contentPadding: PaddingValues = TaraftarPlusButtonDefaults.contentPadding,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    TaraftarPlusTextButton(
        onClick = onClick,
        contentPadding = contentPadding,
        colors = colors,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled
    ) {
        TaraftarPlusButtonContent(
            text = text,
            leadingIcon = leadingIcon
        )
    }
}

@Composable
fun TaraftarPlusTextButton(
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
    TaraftarPlusTextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        contentPadding = TaraftarPlusButtonDefaults.contentPadding,
        colors = colors,
        enabled = enabled,
        text = {
            TaraftarPlusButtonText(
                text = text,
                textStyle = textStyle.copy(fontWeight = FontWeight.Bold)
            )
        },
        leadingIcon = iconComponentWithIconId(leadingIconId)
    )
}


@Composable
fun TaraftarPlusSmallTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.primaryBlue500,
    ),
    padding: PaddingValues = TaraftarPlusButtonDefaults.smallButtonContentPadding,
    text: @Composable () -> Unit,
) {
    TaraftarPlusTextButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        contentPadding = padding,
        enabled = enabled
    ) {
        TaraftarPlusButtonContent(
            text = text,
        )
    }
}

@Composable
fun TaraftarPlusSmallTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.primaryBlue500,
    ),
    padding: PaddingValues = TaraftarPlusButtonDefaults.smallButtonContentPadding,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.buttonTypo,
) {
    TaraftarPlusSmallTextButton(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        padding = padding,
        enabled = enabled
    ) {
        TaraftarPlusButtonText(text = text, textStyle = textStyle)
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
private fun TaraftarPlusButtonContent(
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
private fun TaraftarPlusButtonText(text: String, textStyle: TextStyle) {
    Text(text = text, style = textStyle)
}

object TaraftarPlusButtonDefaults {
    const val DisabledOutlinedButtonBorderAlpha = 0.12f
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
fun TaraftarPlusPrimaryButtonPreview() {
    TaraftarPlusPrimaryButton(onClick = {}, text = "Sonraki", isLoading = false)
}

@Preview
@Composable
fun TaraftarPlusPrimaryButtonLoadingModePreview() {
    TaraftarPlusPrimaryButton(onClick = {}, text = "Button", isLoading = true)
}
