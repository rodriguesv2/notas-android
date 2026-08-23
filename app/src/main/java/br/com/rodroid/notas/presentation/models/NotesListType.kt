package br.com.rodroid.notas.presentation.models

enum class NotesListType {
    LIST, GRID;

    fun next(): NotesListType {
        return when(this) {
            LIST -> GRID
            GRID -> LIST
        }
    }
}