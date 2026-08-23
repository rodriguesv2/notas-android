package br.com.rodroid.notas.data.local.di.repository

import br.com.rodroid.notas.data.local.repository.NoteRepositoryImpl
import br.com.rodroid.notas.domain.repository.NoteRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::NoteRepositoryImpl) bind NoteRepository::class
}