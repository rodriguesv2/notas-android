package br.com.rodroid.notas.presentation.features.editnote

import br.com.rodroid.notas.common.base.MviState

sealed interface EditNoteState: MviState {
    object NoteCreated: EditNoteState
    object NoteUpdated: EditNoteState
    object NoteDeleted : EditNoteState
}