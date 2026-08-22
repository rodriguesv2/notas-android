package br.com.rodroid.notas.presentation.features.editnote

import br.com.rodroid.notas.common.base.MviUiState
import br.com.rodroid.notas.domain.entities.NoteColor

data class EditNoteUiState(
    val loading: Boolean = false,
    val title: String = "",
    val content: String = "",
    val color: Long = NoteColor.CLASSIC_YELLOW.colorHex,
    val colors: List<NoteColor> = NoteColor.entries,
    val shouldShowDeleteModal: Boolean = false,
): MviUiState
