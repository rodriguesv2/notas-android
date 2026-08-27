package br.com.rodroid.notas.domain.di

import br.com.rodroid.notas.domain.usecases.AllNotesUseCase
import br.com.rodroid.notas.domain.usecases.CreateNoteUseCase
import br.com.rodroid.notas.domain.usecases.DarkLightModeValueUseCase
import br.com.rodroid.notas.domain.usecases.DeleteNoteUseCase
import br.com.rodroid.notas.domain.usecases.FetchNoteItemUseCase
import br.com.rodroid.notas.domain.usecases.SaveDarkLightModeFlagUseCase
import br.com.rodroid.notas.domain.usecases.UpdateNoteUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::CreateNoteUseCase)
    singleOf(::DeleteNoteUseCase)
    singleOf(::UpdateNoteUseCase)
    singleOf(::AllNotesUseCase)
    singleOf(::SaveDarkLightModeFlagUseCase)
    singleOf(::DarkLightModeValueUseCase)
    singleOf(::FetchNoteItemUseCase)
}