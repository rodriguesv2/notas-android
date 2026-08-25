package br.com.rodroid.notas.presentation.features.home

import androidx.lifecycle.viewModelScope
import br.com.rodroid.notas.common.base.MviViewModel
import br.com.rodroid.notas.domain.usecases.AllNotesUseCase
import br.com.rodroid.notas.domain.usecases.DarkLightModeValueUseCase
import br.com.rodroid.notas.domain.usecases.SaveDarkLightModeFlagUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val allNotesUseCase: AllNotesUseCase,
    private val saveDarkLightModeFlagUseCase: SaveDarkLightModeFlagUseCase,
    private val darkLightModeValueUseCase: DarkLightModeValueUseCase,
) : MviViewModel<HomeState, HomeUiState>(HomeUiState()) {

    init {
        viewModelScope.launch {
            allNotesUseCase()
                .collect { notes ->
                    updateUiState {
                        it.copy(notes = notes)
                    }
                }

            darkLightModeValueUseCase()
                .collect { darkLightMode ->
                    updateUiState {
                        it.copy(darkLightMode = darkLightMode)
                    }
                }
        }
    }

    fun createNote() {
        emitState(HomeState.CreateNote)
    }

    fun changeListType() {
        updateUiState {
            it.copy(listType = it.listType.next())
        }
    }

    fun changeDarkLightMode() {
        viewModelScope.launch {
            saveDarkLightModeFlagUseCase(uiState.value.darkLightMode.next())
        }
    }
}