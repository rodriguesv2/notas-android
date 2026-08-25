package br.com.rodroid.notas.presentation.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.rodroid.notas.presentation.atomic.templates.HomeTemplate
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navigateToCreateNote: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.state.collect { state ->
            when(state) {
                HomeState.CreateNote -> navigateToCreateNote()
            }
        }
    }

    HomeTemplate(
        notes = uiState.notes,
        onFabClick = viewModel::createNote,
        onListTypeIconClick = viewModel::changeListType,
        listType = uiState.listType,
        onDarkLightModeClick = viewModel::changeDarkLightMode,
        darkLightMode = uiState.darkLightMode
    )
}