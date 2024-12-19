package com.base.onboarding.presentation.splash.contract

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class SplashUiState(
//    val SplashList: List<SplashDm> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
) : Parcelable {

    sealed class PartialState {
        //        data class ShowSplashList(val list: List<SplashDm>) : PartialState()
        object Loading : PartialState()
        data class Error(val msg: String = "", val show: Boolean = false) : PartialState()
        object NetworkError : PartialState()
    }
}