package br.com.rodroid.notas.presentation.features.editnote

import androidx.lifecycle.viewModelScope
import br.com.rodroid.notas.common.base.MviViewModel
import br.com.rodroid.notas.domain.entities.NoteColor
import br.com.rodroid.notas.domain.usecases.DeleteNoteUseCase
import br.com.rodroid.notas.domain.usecases.CreateNoteUseCase
import br.com.rodroid.notas.domain.usecases.FetchNoteItemUseCase
import br.com.rodroid.notas.domain.usecases.UpdateNoteUseCase
import kotlinx.coroutines.launch

class EditNoteViewModel(
    private val createNoteUseCase: CreateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val fetchNoteItemUseCase: FetchNoteItemUseCase,
) : MviViewModel<EditNoteState, EditNoteUiState>(initialUiState = EditNoteUiState()) {

    private var noteId: String? = null

    fun loadNote(noteId: String?) {
        if (noteId == null) return

        viewModelScope.launch {
            fetchNoteItemUseCase(noteId)
                .onSuccess { note ->
                    this@EditNoteViewModel.noteId = note.id

                    updateUiState {
                        it.copy(
                            title = note.title,
                            content = note.content,
                            color = note.color
                        )
                    }
                }
                .onFailure {
                    updateUiState {
                        it.copy(errorMessage = it.errorMessage)
                    }
                }
        }
    }

    fun saveNote() {
        viewModelScope.launch {
            if (noteId == null) {
                createNote()
                return@launch
            }

            updateNote()
        }
    }

    private suspend fun createNote() {
        createNoteUseCase(
            title = uiState.value.title,
            content = uiState.value.content,
            color = uiState.value.color
        )
            .onSuccess { id ->
                noteId = id
                emitState(EditNoteState.NoteCreated)
            }
            .onFailure { exception ->
                updateUiState { it.copy(errorMessage = exception.message) }
            }
    }


    private suspend fun updateNote() {
        updateNoteUseCase(
            noteId = noteId!!,
            title = uiState.value.title,
            content = uiState.value.content,
            color = uiState.value.color
        )
            .onSuccess {
                emitState(EditNoteState.NoteUpdated)
            }
            .onFailure { exception ->
                updateUiState { it.copy(errorMessage = exception.message) }
            }
    }

    fun colorSelected(noteColor: NoteColor) {
        updateUiState {
            it.copy(color = noteColor.colorHex)
        }
    }

    fun titleChanged(value: String) {
        updateUiState {
            it.copy(title = value)
        }
    }

    fun contentChanged(value: String) {
        updateUiState {
            it.copy(content = value)
        }
    }

    fun deleteNote() {
        updateUiState {
            it.copy(shouldShowDeleteModal = true)
        }
    }


    fun deletionConfirmed() {
        viewModelScope.launch {
            noteId?.let { id ->
                deleteNoteUseCase(id)
                    .onSuccess {
                        emitState(EditNoteState.NoteDeleted)
                    }
                    .onFailure { exception ->
                        updateUiState { it.copy(errorMessage = exception.message) }
                    }
            }
        }
    }

    fun dismissDeleteModal() {
        updateUiState {
            it.copy(shouldShowDeleteModal = false)
        }
    }

    fun dismissErrorModal() {
        updateUiState {
            it.copy(errorMessage = null)
        }
    }
}