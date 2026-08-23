package br.com.rodroid.notas.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class MviViewModel<STATE: MviState, UISTATE: MviUiState>(
    initialUiState: UISTATE
): ViewModel() {

    private val _uiState: MutableStateFlow<UISTATE> = MutableStateFlow(initialUiState)
    val uiState = _uiState.asStateFlow()

    private val _state: MutableSharedFlow<STATE> = MutableSharedFlow()
    val state = _state.asSharedFlow()

    protected fun emitState(newState: STATE) {
        viewModelScope.launch {
            _state.emit(newState)
        }
    }

    protected fun updateUiState(block: (UISTATE) -> UISTATE){
        _uiState.update { block(it) }
    }
}