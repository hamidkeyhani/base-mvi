package com.fourplay.common.extensions

import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController

@Composable
fun <T> NavController.getBackStackLiveData(
    key: String,
): MutableLiveData<T>? {
    val backStackEntry = this.currentBackStackEntry?.savedStateHandle
    val liveData = backStackEntry?.getLiveData<T>(key)
    removeBackStackData(key)
    return liveData
}


fun <T> NavController.setBackStackData(
    key: String,
    value: T,
) {
    val backStackEntry = this.previousBackStackEntry?.savedStateHandle
    backStackEntry?.set(key, value)
}

fun <T> NavController.getBackStackData(
    key: String
) : T? {
    val backStackEntry = this.previousBackStackEntry?.savedStateHandle
    return backStackEntry?.get<T>(key)
}

fun <T> NavController.setCurrentBackStackData(
    key: String,
    value: T,
) {
    val backStackEntry = this.currentBackStackEntry?.savedStateHandle
    backStackEntry?.set(key, value)
}

fun NavController.removeBackStackData(
    key: String,
) {
    val backStackEntry = this.previousBackStackEntry?.savedStateHandle
    backStackEntry?.set(key, null)
}
