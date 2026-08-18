package br.com.rodroid.notas.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination {
    object Home: Destination()
}