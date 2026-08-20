package br.com.rodroid.notas.domain.entities

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val color: Long,
)