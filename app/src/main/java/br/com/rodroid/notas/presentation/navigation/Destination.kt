package br.com.rodroid.notas.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination {
    @Serializable
    data object Home: Destination()

    @Serializable
    data object EditNote: Destination()
}