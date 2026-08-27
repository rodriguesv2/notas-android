package br.com.rodroid.notas.presentation.features.editnote

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.rodroid.notas.R
import br.com.rodroid.notas.presentation.atomic.organism.GenericModalOrganism
import br.com.rodroid.notas.presentation.atomic.templates.EditNoteTemplate
import br.com.rodroid.notas.presentation.extensions.toast

@Composable
fun EditNoteScreen(
    navigateBack: () -> Unit,
    viewModel: EditNoteViewModel,
    noteId: String? = null,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(viewModel) {
        viewModel.loadNote(noteId)
    }

    LaunchedEffect(viewModel) {
        viewModel.state.collect { state ->
            when (state) {
                EditNoteState.NoteCreated -> context.toast(R.string.edit_note_created_message)
                EditNoteState.NoteDeleted -> navigateBack()
                EditNoteState.NoteUpdated -> context.toast(R.string.edit_note_updated_message)
            }
        }
    }

    if (uiState.shouldShowDeleteModal) {
        GenericModalOrganism(
            title = stringResource(R.string.edit_note_delete_modal_title),
            subtitle = stringResource(R.string.edit_note_delete_modal_subtitle),
            onMainButtonClick = viewModel::deletionConfirmed,
            onSecondaryButtonClick = viewModel::dismissDeleteModal,
            onDismissRequest = viewModel::dismissDeleteModal,
        )
    }
    if (uiState.errorMessage != null) {
        GenericModalOrganism(
            title = stringResource(R.string.generic_error_modal_title),
            subtitle = stringResource(R.string.generic_error_modal_subtitle),
            onMainButtonClick = viewModel::dismissErrorModal,
            onDismissRequest = viewModel::dismissErrorModal,
        )
    }
    EditNoteTemplate(
        colors = uiState.colors,
        colorSelected = uiState.color,
        onColorClick = viewModel::colorSelected,
        titleValue = uiState.title,
        onTitleChange = viewModel::titleChanged,
        contentValue = uiState.content,
        onContentChanged = viewModel::contentChanged,
        onDeleteClick = viewModel::deleteNote,
        onSaveClick = viewModel::saveNote
    )
}