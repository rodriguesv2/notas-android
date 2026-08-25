package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.common.model.DarkLightModeType
import br.com.rodroid.notas.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow

class DarkLightModeValueUseCase(
    private val storageRepository: StorageRepository,
) {
    operator fun invoke(): Flow<DarkLightModeType> {
        return storageRepository.getDarkLightMode()
    }
}