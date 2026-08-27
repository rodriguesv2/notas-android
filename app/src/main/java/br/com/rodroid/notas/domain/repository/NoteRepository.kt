package br.com.rodroid.notas.domain.repository

import br.com.rodroid.notas.data.local.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllItems(): Flow<List<NoteEntity>>
    suspend fun createNote(note: NoteEntity)
    suspend fun deleteNote(noteId: String)
    suspend fun updateNote(note: NoteEntity)
    suspend fun getNoteById(noteId: String): NoteEntity?
}