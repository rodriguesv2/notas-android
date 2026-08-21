package br.com.rodroid.notas.presentation.features.editnote

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.rodroid.notas.presentation.atomic.templates.EditNoteTemplate
import org.koin.androidx.compose.koinViewModel

@Composable
fun EditNoteScreen(
    viewModel: EditNoteViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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