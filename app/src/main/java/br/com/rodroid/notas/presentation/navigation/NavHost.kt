package br.com.rodroid.notas.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import br.com.rodroid.notas.presentation.features.editnote.EditNoteScreen
import br.com.rodroid.notas.presentation.features.editnote.EditNoteViewModel
import br.com.rodroid.notas.presentation.features.home.HomeScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavHost() {
    val backStack = remember { mutableStateListOf<Destination>(Destination.Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when(key) {
                is Destination.Home -> NavEntry(key) {
                    HomeScreen(
                        navigateToCreateNote = {
                            backStack.add(Destination.EditNote())
                        },
                        navigateToEditNote = {
                            backStack.add(Destination.EditNote(it))
                        }
                    )
                }

                is Destination.EditNote -> NavEntry(key) {
                    val id = System.currentTimeMillis()

                    EditNoteScreen(
                        viewModel = koinViewModel(key = id.toString()),
                        navigateBack = {
                            backStack.removeLastOrNull()
                        },
                        noteId = key.noteId
                    )
                }
            }
        }
    )
}