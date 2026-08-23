package br.com.rodroid.notas.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.rodroid.notas.domain.entities.Note

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val content: String,
    val color: Long,
) {
    fun toDomain(): Note = Note(
        id = id,
        title = title,
        content = content,
        color = color,
    )

    companion object {
        fun fromDomain(note: Note): NoteEntity = NoteEntity(
            id = note.id,
            title = note.title,
            content = note.content,
            color = note.color,
        )
    }
}
