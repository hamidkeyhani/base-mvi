package com.base.designsystem.components.appBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.base.designsystem.R
import com.base.designsystem.components.spacer.WidthSpacer
import com.base.designsystem.theme.mediumTitle
import com.base.designsystem.theme.primary900
import com.base.designsystem.theme.white
import com.base.designsystem.utils.clickableNoRipple

@Composable
fun MviAppBar(
    modifier: Modifier = Modifier,
    appBarConfig: AppBarConfig,
) {
    Row(
        modifier = modifier
            .height(68.dp)
            .background(
                color = MaterialTheme.colorScheme.primary900,
                shape = RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (appBarConfig.showStartLogo) {
            WidthSpacer(value = 25)
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                modifier = Modifier
                    .size(40.dp)
                    .padding(10.dp)
                    .clickableNoRipple { appBarConfig.onTrailingClicked() },
                contentDescription = "",
            )
        }
        else if(appBarConfig.showBackButton) {
            WidthSpacer(value = 32)
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                modifier = Modifier
                    .width(24.dp)
                    .clickableNoRipple { appBarConfig.onNavigateUp() },
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.white)
            )
        }
        else if (appBarConfig.titleIcon == null) {
            WidthSpacer(value = 56)
        } else {
            WidthSpacer(value = 32)
            Image(
                painter = painterResource(id = appBarConfig.titleIcon),
                modifier = Modifier
                    .width(24.dp)
                    .clickableNoRipple { appBarConfig.onTitleIconClicked() },
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.white)
            )
        }

        Spacer(
            modifier = Modifier
                .width(8.dp)
        )
        Text(
            text = appBarConfig.appBarTitle,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.mediumTitle.copy(fontWeight = FontWeight(510)),
            color = MaterialTheme.colorScheme.white,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        if (appBarConfig.trailingIcon != null) {
            Image(
                painter = painterResource(id = appBarConfig.trailingIcon),
                modifier = Modifier
                    .size(40.dp)
                    .clickableNoRipple { appBarConfig.onTrailingClicked() },
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.white)
            )
            WidthSpacer(value = 24)
        } else
            WidthSpacer(value = 64)

    }
}

@Preview
@Composable
fun MviAppBarPreview() {
    MviAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            titleIcon = R.drawable.baseline_5g_24,
            trailingIcon = R.drawable.baseline_5g_24
        )
    )
}

@Preview
@Composable
fun MviAppBarLognTitlePreview() {
    MviAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "This is long text for title of appbar",
            titleIcon = R.drawable.baseline_5g_24,
            trailingIcon = R.drawable.baseline_5g_24
        ),
    )
}

@Preview
@Composable
fun MviAppBarWithStartIconPreview() {
    MviAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            titleIcon = R.drawable.baseline_5g_24,
        )
    )
}

@Preview
@Composable
fun MviAppBarWithEndIconPreview() {
    MviAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            trailingIcon = R.drawable.baseline_5g_24
        )
    )
}

@Preview
@Composable
fun MviAppBarWithStartLogoPreview() {
    MviAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            showStartLogo = true,
        )
    )
}

@Preview
@Composable
fun MviAppBarWithStartAndEndIconPreview() {
    MviAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            titleIcon = R.drawable.baseline_5g_24,
            trailingIcon = R.drawable.baseline_5g_24
        )
    )
}