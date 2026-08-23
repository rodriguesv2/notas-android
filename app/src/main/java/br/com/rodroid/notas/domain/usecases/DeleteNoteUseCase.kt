package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(noteId: String): Result<Unit> {
        return try {
            repository.deleteNote(noteId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}