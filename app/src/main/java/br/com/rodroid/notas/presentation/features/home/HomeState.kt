package br.com.rodroid.notas.presentation.features.home

import br.com.rodroid.notas.common.base.MviState

sealed interface HomeState: MviState {
    data object CreateNote: HomeState
}