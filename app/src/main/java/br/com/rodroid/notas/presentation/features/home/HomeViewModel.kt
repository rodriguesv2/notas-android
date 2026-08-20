package br.com.rodroid.notas.presentation.features.home

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.rodroid.notas.common.base.MviViewModel
import br.com.rodroid.notas.domain.entities.Note
import kotlin.random.Random

class HomeViewModel: MviViewModel<HomeState, HomeUiState>(HomeUiState()) {

    init {
        updateUiState {
            it.copy(
                notes = List(15) { item ->
                    Note(
                        id = item.toString(),
                        title = "Titulo #${item + 1}",
                        content = LoremIpsum(Random.nextInt(30)).values.joinToString(),
                        color = 0xFFFFF275
                    )
                }
            )
        }
    }
}