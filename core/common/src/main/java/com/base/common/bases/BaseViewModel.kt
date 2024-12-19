package com.base.common.bases

import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private const val SAVED_UI_STATE_KEY = "savedUiStateKey"

@OptIn(FlowPreview::class)
abstract class BaseViewModel<UI_STATE : Parcelable, PARTIAL_UI_STATE, EVENT, INTENT>(
    savedStateHandle: SavedStateHandle, initialState: UI_STATE
) : ViewModel() {
    private val intentFlow = MutableSharedFlow<INTENT>()

    val uiState = savedStateHandle.getStateFlow(com.base.common.bases.SAVED_UI_STATE_KEY, initialState)

    private val eventChannel = Channel<EVENT>(Channel.BUFFERED)
    val event = eventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            intentFlow.flatMapMerge {
//                    Timber.i("mapIntent $it")
                mapIntents(it)
            }.scan(uiState.value, ::reduceUiState)
//                .catch { Timber.e("reduceUiState $it") }
                .collect {
                    savedStateHandle[com.base.common.bases.SAVED_UI_STATE_KEY] = it
                }
        }
    }

    fun acceptIntent(intent: INTENT) = viewModelScope.launch {
        intentFlow.emit(intent)
    }

    protected fun publishEvent(event: EVENT) {
        viewModelScope.launch {
            eventChannel.send(event)
        }
    }

    protected abstract fun mapIntents(intent: INTENT): Flow<PARTIAL_UI_STATE>

    protected abstract fun reduceUiState(
        previousState: UI_STATE, partialState: PARTIAL_UI_STATE
    ): UI_STATE
}