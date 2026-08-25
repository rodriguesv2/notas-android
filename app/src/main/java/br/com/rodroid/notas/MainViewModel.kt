package br.com.rodroid.notas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rodroid.notas.common.model.DarkLightModeType
import br.com.rodroid.notas.domain.usecases.DarkLightModeValueUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val darkLightModeValueUseCase: DarkLightModeValueUseCase
) : ViewModel() {
    private val _darkLightMode = MutableStateFlow(DarkLightModeType.AUTO)
    val darkLightMode = _darkLightMode.asStateFlow()

    init {
        viewModelScope.launch {
            darkLightModeValueUseCase()
                .collect { darkLightMode ->
                    _darkLightMode.value = darkLightMode
                }
        }
    }
}