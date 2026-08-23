package br.com.rodroid.notas.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination {
    @Serializable
    object Home: Destination()

    @Serializable
    data class EditNote(val id: Long = System.currentTimeMillis()): Destination()
}