package br.com.rodroid.notas.common.model

enum class DarkLightModeType {
    AUTO, DARk, LIGHT;

    fun next(): DarkLightModeType {
        return when (this) {
            AUTO -> DARk
            DARk -> LIGHT
            LIGHT -> AUTO
        }
    }
}