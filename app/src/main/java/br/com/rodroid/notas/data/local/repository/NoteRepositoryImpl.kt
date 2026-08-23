package br.com.rodroid.notas.data.local.repository

import br.com.rodroid.notas.data.local.dao.NoteDao
import br.com.rodroid.notas.data.local.entities.NoteEntity
import br.com.rodroid.notas.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {
    override fun getAllItems(): Flow<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    override suspend fun createNote(note: NoteEntity) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(noteId: String) {
        noteDao.deleteNoteById(noteId)
    }

    override suspend fun updateNote(note: NoteEntity) {
        noteDao.updateNote(note)
    }
}