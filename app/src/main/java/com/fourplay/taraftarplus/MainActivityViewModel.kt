package com.fourplay.taraftarplus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<MainActivityUiState>(MainActivityUiState.Loading)
    val uiState: StateFlow<MainActivityUiState> = _uiState

    init {
        viewModelScope.launch {
            delay(0)
            _uiState.value = MainActivityUiState.Success
        }
    }

}

sealed interface MainActivityUiState {
    object Loading : MainActivityUiState
    object Success : MainActivityUiState
}
