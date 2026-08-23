package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.data.local.entities.NoteEntity
import br.com.rodroid.notas.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        noteId: String,
        title: String,
        content: String,
        color: Long,
    ): Result<Unit> {
        try {
            val entity = NoteEntity(
                id = noteId,
                title = title,
                content = content,
                color = color,
            )
            repository.updateNote(entity)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}