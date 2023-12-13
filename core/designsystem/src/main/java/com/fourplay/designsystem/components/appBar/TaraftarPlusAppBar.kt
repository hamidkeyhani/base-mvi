package com.fourplay.designsystem.components.appBar

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
import com.fourplay.designsystem.R
import com.fourplay.designsystem.components.spacer.WidthSpacer
import com.fourplay.designsystem.theme.mediumTitle
import com.fourplay.designsystem.theme.primary900
import com.fourplay.designsystem.theme.white
import com.fourplay.designsystem.utils.clickableNoRipple

@Composable
fun TaraftarPlusAppBar(
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
                painter = painterResource(id = R.drawable.logo_without_text),
                modifier = Modifier
                    .size(40.dp)
                    .padding(10.dp)
                    .clickableNoRipple { appBarConfig.onTrailingClicked() },
                contentDescription = "",
            )
        }
        else if(appBarConfig.showBackButton){
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
fun TaraftarPlusAppBarPreview() {
    TaraftarPlusAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            titleIcon = R.drawable.ic_search,
            trailingIcon = R.drawable.ic_trash
        )
    )
}

@Preview
@Composable
fun TaraftarPlusAppBarLognTitlePreview() {
    TaraftarPlusAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "This is long text for title of appbar",
            titleIcon = R.drawable.ic_search,
            trailingIcon = R.drawable.ic_trash
        ),
    )
}

@Preview
@Composable
fun TaraftarPlusAppBarWithStartIconPreview() {
    TaraftarPlusAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            titleIcon = R.drawable.ic_search,
        )
    )
}

@Preview
@Composable
fun TaraftarPlusAppBarWithEndIconPreview() {
    TaraftarPlusAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            trailingIcon = R.drawable.ic_trash
        )
    )
}

@Preview
@Composable
fun TaraftarPlusAppBarWithStartLogoPreview() {
    TaraftarPlusAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            showStartLogo = true,
        )
    )
}

@Preview
@Composable
fun TaraftarPlusAppBarWithStartAndEndIconPreview() {
    TaraftarPlusAppBar(
        appBarConfig = AppBarConfig(
            appBarTitle = "Profile",
            titleIcon = R.drawable.ic_search,
            trailingIcon = R.drawable.ic_trash
        )
    )
}