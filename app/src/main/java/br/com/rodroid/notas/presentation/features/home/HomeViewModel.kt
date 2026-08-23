package br.com.rodroid.notas.presentation.features.home

import androidx.lifecycle.viewModelScope
import br.com.rodroid.notas.common.base.MviViewModel
import br.com.rodroid.notas.domain.usecases.AllNotesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val allNotesUseCase: AllNotesUseCase
) : MviViewModel<HomeState, HomeUiState>(HomeUiState()) {

    init {
        viewModelScope.launch {
            allNotesUseCase()
                .collect { notes ->
                    updateUiState {
                        it.copy(notes = notes)
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
        //TODO
    }
}