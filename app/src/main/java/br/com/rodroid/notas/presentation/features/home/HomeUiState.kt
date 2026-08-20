package br.com.rodroid.notas.presentation.features.home

import br.com.rodroid.notas.common.base.MviUiState
import br.com.rodroid.notas.domain.entities.Note

data class HomeUiState(
    val loading: Boolean = false,
    val notes: List<Note> = emptyList()
): MviUiState