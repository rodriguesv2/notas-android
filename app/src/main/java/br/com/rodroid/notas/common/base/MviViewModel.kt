package br.com.rodroid.notas.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class MviViewModel<STATE: MviState, UISTATE: MviUiState>(
    initialUiState: UISTATE
): ViewModel() {

    private val _uiState: MutableStateFlow<UISTATE> = MutableStateFlow(initialUiState)
    val uiState = _uiState.asStateFlow()

    private val _state: MutableSharedFlow<STATE> = MutableSharedFlow()
    val state = _state.asSharedFlow()

    protected fun emitState(newState: STATE) {
        _state.tryEmit(newState)
    }

    protected fun updateUiState(newUiState: UISTATE) {
        _uiState.update { newUiState }
    }
}