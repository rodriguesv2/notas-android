package br.com.rodroid.notas.presentation.di.modules.viewmodels

import br.com.rodroid.notas.MainViewModel
import br.com.rodroid.notas.presentation.features.editnote.EditNoteViewModel
import br.com.rodroid.notas.presentation.features.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainViewModel)

    viewModelOf(::HomeViewModel)
    viewModelOf(::EditNoteViewModel)
}