package br.com.rodroid.notas.domain.usecases

import br.com.rodroid.notas.common.model.DarkLightModeType
import br.com.rodroid.notas.domain.repository.StorageRepository

class SaveDarkLightModeFlagUseCase(
    private val storageRepository: StorageRepository
) {
    suspend operator fun invoke(darkLightMode: DarkLightModeType): Result<Unit> {
        try {
            storageRepository.setDarkLightMode(darkLightMode)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}