package com.fourplay.designsystem.components.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fourplay.designsystem.R
import com.fourplay.designsystem.components.spacer.HeightSpacer
import com.fourplay.designsystem.theme.white
import com.fourplay.designsystem.utils.clickableNoRipple

@Composable
fun TaraftarPlusNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.white,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 4.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }

}

@Composable
fun RowScope.TaraftarPlusNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: Int,
    selectedIcon: Int,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxHeight()
            .weight(1.0f)
            .clickableNoRipple { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeightSpacer(value = 20)
        val icon = if (selected) selectedIcon else icon
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.weight(1.0f))
        AnimatedVisibility(visible = selected) {
            Image(
                painter = painterResource(id = R.drawable.ic_bottom_nav_selector),
                contentDescription = null
            )
        }
    }

}