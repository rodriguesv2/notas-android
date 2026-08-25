package br.com.rodroid.notas.data.local.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import br.com.rodroid.notas.common.model.DarkLightModeType
import br.com.rodroid.notas.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StorageRepositoryImpl(
    private val dataStore: DataStore<Preferences>
): StorageRepository {
    override suspend fun setDarkLightMode(darkLightMode: DarkLightModeType) {
        dataStore.edit { settings ->
            settings[PreferencesKeys.DARK_LIGHT_MODE] = darkLightMode.name
        }
    }

    override fun getDarkLightMode(): Flow<DarkLightModeType> {
        return dataStore.data.map { preferences ->
            preferences[PreferencesKeys.DARK_LIGHT_MODE]?.let {
                DarkLightModeType.valueOf(it)
            } ?: DarkLightModeType.AUTO
        }
    }

    object PreferencesKeys {
        val DARK_LIGHT_MODE = stringPreferencesKey("dark_light_mode")
    }
}