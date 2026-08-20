package br.com.rodroid.notas.presentation.features.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.rodroid.notas.presentation.atomic.templates.HomeTemplate
import org.koin.androidx.compose.koinViewModel
import kotlin.random.Random

@Composable
fun HomeScreen(
    navigateToCreateNote: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val notesSample = List(15) { item ->
        "Titulo #${item + 1}" to LoremIpsum(Random.nextInt(30)).values.joinToString()
    }

    HomeTemplate(notesSample)
}