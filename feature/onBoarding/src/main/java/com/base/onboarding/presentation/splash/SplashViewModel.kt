package com.base.onboarding.presentation.splash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.base.common.bases.BaseViewModel
import com.base.onboarding.navigation.OnBoardingRoutesConstants
import com.base.onboarding.presentation.splash.contract.SplashEvent
import com.base.onboarding.presentation.splash.contract.SplashIntent
import com.base.onboarding.presentation.splash.contract.SplashUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    initialState: SplashUiState,
//    private val getTransactionsUseCase: GetTransactionsUseCase
) : BaseViewModel<SplashUiState, SplashUiState.PartialState, SplashEvent, SplashIntent>(
    savedStateHandle,
    initialState
) {

    init {
        viewModelScope.launch {
            delay(2000)
//            acceptIntent(SplashIntent.FinishDelay)
        }
    }

    override fun mapIntents(intent: SplashIntent): Flow<SplashUiState.PartialState> =
        when (intent) {
            SplashIntent.CloseErrorDialog -> flowOf(
                SplashUiState.PartialState.Error(
                    show = false
                )
            )
//            SplashIntent.ContinueButtonClick -> callApi()
            SplashIntent.FinishDelay -> navigateTo(OnBoardingRoutesConstants.ON_BOARDING_ROUT)
        }


    private fun navigateTo(route: String): Flow<SplashUiState.PartialState> {
        publishEvent(SplashEvent.NavigateTo(route))
        return emptyFlow()
    }

    override fun reduceUiState(
        previousState: SplashUiState,
        partialState: SplashUiState.PartialState,
    ): SplashUiState = when (partialState) {

//        SplashUiState.PartialState.EmptyList -> previousState.copy(
//            transactionList = emptyList(), isLoading = false, isError = false
//        )

        is SplashUiState.PartialState.Error -> previousState.copy(
            isError = partialState.show,
            errorMessage = partialState.msg,
            isLoading = false
        )

        SplashUiState.PartialState.Loading -> previousState.copy(
            isLoading = true,
            isError = false
        )

        SplashUiState.PartialState.NetworkError -> previousState.copy(
            isLoading = false,
            isError = true
        )

//        is SplashUiState.PartialState.ShowSplashList -> {
//            previousState.copy(
//                transactionList = partialState.list, isLoading = false, isError = false
//            )
//        }
    }

//    private fun fetchSplashList(): Flow<SplashUiState.PartialState> = flow {
//        getTransactionsUseCase.execute().doOnSuccess { campaignList ->
//            if (campaignList.isEmpty()) emit(SplashUiState.PartialState.EmptyList)
//            else emit(SplashUiState.PartialState.ShowTransactionList(campaignList))
//        }.doOnFailure {
//            emit(SplashUiState.PartialState.Error(it.message.orEmpty()))
//        }.doOnLoading {
//            emit(SplashUiState.PartialState.Loading)
//        }.doOnNetworkError {
//            emit(SplashUiState.PartialState.NetworkError)
//        }.collect()

}