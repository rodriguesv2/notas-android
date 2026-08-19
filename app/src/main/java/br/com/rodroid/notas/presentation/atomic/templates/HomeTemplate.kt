package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.rodroid.notas.presentation.atomic.organism.NoteCardOrganism
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme
import kotlin.random.Random

@Composable
fun HomeTemplate(
    notes: List<Pair<String, String>>
) {
    Scaffold { innerPadding ->
        val cardsSpacingMargin = 12.dp

        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            columns = StaggeredGridCells.Adaptive(150.dp),
            verticalItemSpacing = cardsSpacingMargin,
            horizontalArrangement = Arrangement.spacedBy(cardsSpacingMargin)
        ) {
            items(notes) { note ->
                NoteCardOrganism(
                    note.first,
                    note.second,
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    val notesSample = List(15) { item ->
        "Titulo #${item + 1}" to LoremIpsum(Random.nextInt(30)).values.joinToString()
    }
    NotasTheme {
        HomeTemplate(notesSample)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    val notesSample = List(15) { item ->
        "Titulo #${item + 1}" to LoremIpsum(Random.nextInt(30)).values.joinToString()
    }
    NotasTheme {
        HomeTemplate(notesSample)
    }
}