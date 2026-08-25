package br.com.rodroid.notas.common.model

enum class DarkLightModeType {
    AUTO, DARK, LIGHT;

    fun next(): DarkLightModeType {
        return when (this) {
            AUTO -> DARK
            DARK -> LIGHT
            LIGHT -> AUTO
        }
    }
}