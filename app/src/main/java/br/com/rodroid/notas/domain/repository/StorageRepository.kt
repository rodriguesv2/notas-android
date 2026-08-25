package br.com.rodroid.notas.domain.repository

import br.com.rodroid.notas.common.model.DarkLightModeType
import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    suspend fun setDarkLightMode(darkLightMode: DarkLightModeType)
    fun getDarkLightMode(): Flow<DarkLightModeType>
}