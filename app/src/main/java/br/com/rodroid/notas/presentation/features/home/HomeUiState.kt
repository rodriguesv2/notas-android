package br.com.rodroid.notas.presentation.features.home

import br.com.rodroid.notas.common.base.MviUiState
import br.com.rodroid.notas.domain.entities.Note
import br.com.rodroid.notas.presentation.models.NotesListType

data class HomeUiState(
    val loading: Boolean = false,
    val notes: List<Note> = emptyList(),
    val errorMessage: String? = null,
    val listType: NotesListType = NotesListType.GRID,
): MviUiState