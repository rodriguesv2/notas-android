package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.domain.entities.Note
import br.com.rodroid.notas.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AllNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return repository.getAllItems().map { entities ->
            entities.map { entity ->
                entity.toDomain()
            }
        }
    }
}