package br.com.rodroid.notas.presentation.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.rodroid.notas.presentation.atomic.templates.HomeTemplate
import org.koin.androidx.compose.koinViewModel
import kotlin.random.Random

@Composable
fun HomeScreen(
    navigateToCreateNote: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeTemplate(
        notes = uiState.notes,
        onFabClick = {},
    )
}