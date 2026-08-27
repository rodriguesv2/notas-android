package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.data.local.entities.NoteEntity
import br.com.rodroid.notas.domain.repository.NoteRepository

class FetchNoteItemUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(noteId: String): Result<NoteEntity> {
        try {
            val result = repository.getNoteById(noteId)

            return result?.let {
                Result.success(it)
            } ?: kotlin.run {
                Result.failure(IllegalArgumentException("Note not found"))
            }
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }
}