package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodroid.notas.domain.entities.Note
import br.com.rodroid.notas.presentation.atomic.organism.NoteCardOrganism
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme
import kotlin.random.Random

@Composable
fun HomeTemplate(
    notes: List<Note>,
    onFabClick: () -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFabClick,
            ) {
                Text(
                    text = "+",
                    fontSize = 24.sp
                )
            }
        }
    ) { innerPadding ->
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
                    title = note.title,
                    content = note.content,
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    val notesSample = List(15) { item ->
        Note(
            id = item.toString(),
            title = "Titulo #${item + 1}",
            content = LoremIpsum(Random.nextInt(30)).values.joinToString(),
            color = 0xFFFFF275
        )
    }
    NotasTheme {
        HomeTemplate(notesSample, {})
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    val notesSample = List(15) { item ->
        Note(
            id = item.toString(),
            title = "Titulo #${item + 1}",
            content = LoremIpsum(Random.nextInt(30)).values.joinToString(),
            color = 0xFFFFF275
        )
    }
    NotasTheme {
        HomeTemplate(notesSample, {})
    }
}