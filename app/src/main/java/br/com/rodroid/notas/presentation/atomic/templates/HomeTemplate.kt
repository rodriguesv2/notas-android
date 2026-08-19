package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration
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
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            columns = StaggeredGridCells.Adaptive(150.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(notes) {
                notes.forEach { note ->
                    NoteCardOrganism(
                        note.first,
                        note.second,
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    NotasTheme {
        HomeTemplate(notesSample)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    NotasTheme {
        HomeTemplate(notesSample)
    }
}

val notesSample = List(15) { item ->
    "Titulo #$item" to LoremIpsum(Random.nextInt(30)).values.joinToString()
}