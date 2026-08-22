package br.com.rodroid.notas.presentation.features.editnote

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.rodroid.notas.R
import br.com.rodroid.notas.presentation.atomic.organism.GenericModalOrganism
import br.com.rodroid.notas.presentation.atomic.templates.EditNoteTemplate
import org.koin.androidx.compose.koinViewModel

@Composable
fun EditNoteScreen(
    viewModel: EditNoteViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.shouldShowDeleteModal) {
        GenericModalOrganism(
            title = stringResource(R.string.edit_note_delete_modal_title),
            subtitle = stringResource(R.string.edit_note_delete_modal_subtitle),
            onMainButtonClick = {},
            onSecondaryButtonClick = {},
        )
    }
    EditNoteTemplate(
        colors = uiState.colors,
        colorSelected = uiState.color,
        onColorClick = {},
        titleValue = uiState.title,
        onTitleChange = {},
        contentValue = uiState.content,
        onContentChanged = {},
        onDeleteClick = {},
        onSaveClick = {}
    )
}