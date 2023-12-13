package com.fourplay.designsystem.components.appBar

data class AppBarConfig(
    val onNavigateUp: () -> Unit = {},
    val titleIcon: Int? = null,
    val appBarTitle: String,
    val showStartLogo:Boolean = false,
    val showBackButton: Boolean = true,
    val trailingIcon: Int? = null,
    val trailingText: String? = null,
    val onTitleIconClicked: () -> Unit = {},
    val onTrailingClicked: () -> Unit = {}
)
