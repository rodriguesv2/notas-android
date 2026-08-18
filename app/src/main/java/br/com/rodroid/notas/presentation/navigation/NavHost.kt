package br.com.rodroid.notas.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay

@Composable
fun NavHost() {
    val backStack = remember { mutableStateListOf<Destination>(Destination.Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when(key) {
                is Destination.Home -> NavEntry(key) {
                    Text("Home Page")
                }
            }
        }
    )
}