package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.data.local.entities.NoteEntity
import br.com.rodroid.notas.domain.repository.NoteRepository
import java.util.UUID

class CreateNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        title: String,
        content: String,
        color: Long,
    ): Result<String> {
        try {
            val id = UUID.randomUUID().toString()
            val entity = NoteEntity(
                id = id,
                title = title,
                content = content,
                color = color
            )

            repository.createNote(entity)
            return Result.success(id)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}