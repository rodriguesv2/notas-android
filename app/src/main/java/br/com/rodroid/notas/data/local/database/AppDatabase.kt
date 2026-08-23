package br.com.rodroid.notas.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.rodroid.notas.data.local.dao.NoteDao
import br.com.rodroid.notas.data.local.entities.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
