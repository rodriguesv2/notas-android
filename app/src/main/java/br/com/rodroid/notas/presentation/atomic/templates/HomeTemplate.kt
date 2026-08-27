package br.com.rodroid.notas.presentation.atomic.templates

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodroid.notas.R
import br.com.rodroid.notas.common.model.DarkLightModeType
import br.com.rodroid.notas.domain.entities.Note
import br.com.rodroid.notas.domain.entities.NoteColor
import br.com.rodroid.notas.presentation.atomic.organism.NoteCardOrganism
import br.com.rodroid.notas.presentation.models.NotesListType
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTemplate(
    notes: List<Note>,
    onFabClick: () -> Unit,
    onListTypeIconClick: () -> Unit,
    onDarkLightModeClick: () -> Unit,
    darkLightMode: DarkLightModeType,
    onItemNoteClick: (id: String) -> Unit,
    listType: NotesListType = NotesListType.LIST,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                {},
                actions = {
                    IconButton(onClick = onDarkLightModeClick) {
                        Icon(
                            painter = painterResource(
                                when (darkLightMode) {
                                    DarkLightModeType.AUTO -> R.drawable.ic_light_mode_auto
                                    DarkLightModeType.DARK -> R.drawable.ic_dark_mode
                                    else -> R.drawable.ic_light_mode
                                }
                            ),
                            contentDescription = "",
                        )
                    }
                    IconButton(onClick = onListTypeIconClick) {
                        Icon(
                            painter = painterResource(
                                when (listType) {
                                    NotesListType.LIST -> R.drawable.ic_grid
                                    else -> R.drawable.ic_list
                                }
                            ),
                            contentDescription = "",
                        )
                    }
                }
            )
        },
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

        when (listType) {
            NotesListType.LIST -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        items = notes,
                        key = { it.id },
                    ) { note ->
                        NoteCardOrganism(
                            modifier = Modifier
                                .clickable(
                                    onClick = { onItemNoteClick(note.id) }
                                ),
                            title = note.title,
                            content = note.content,
                            color = Color(note.color)
                        )
                    }
                }
            }

            NotesListType.GRID -> {
                LazyVerticalStaggeredGrid(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(16.dp),
                    columns = StaggeredGridCells.Adaptive(150.dp),
                    verticalItemSpacing = cardsSpacingMargin,
                    horizontalArrangement = Arrangement.spacedBy(cardsSpacingMargin)
                ) {
                    items(
                        items = notes,
                        key = { it.id },
                    ) { note ->
                        NoteCardOrganism(
                            modifier = Modifier
                                .clickable(
                                    onClick = { onItemNoteClick(note.id) }
                                ),
                            title = note.title,
                            content = note.content,
                            color = Color(note.color)
                        )
                    }
                }
            }
        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    DefaultPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewLight() {
    DefaultPreview()
}

@Composable
private fun DefaultPreview() {
    val notesSample = List(15) { item ->
        Note(
            id = item.toString(),
            title = "Titulo #${item + 1}",
            content = LoremIpsum(Random.nextInt(30)).values.joinToString(),
            color = NoteColor
                .entries
                .toTypedArray()
                .random()
                .colorHex
        )
    }
    NotasTheme {
        HomeTemplate(
            notes = notesSample,
            onFabClick = {},
            onListTypeIconClick = {},
            listType = NotesListType.GRID,
            onDarkLightModeClick = {},
            onItemNoteClick = {},
            darkLightMode = DarkLightModeType.DARK
        )
    }
}