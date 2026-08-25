package br.com.rodroid.notas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.rodroid.notas.common.model.DarkLightModeType
import br.com.rodroid.notas.presentation.navigation.NavHost
import br.com.rodroid.notas.presentation.ui.theme.NotasTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkLightMode by viewModel.darkLightMode.collectAsStateWithLifecycle()

            NotasTheme(
                darkTheme = when (darkLightMode) {
                    DarkLightModeType.AUTO -> isSystemInDarkTheme()
                    DarkLightModeType.DARK -> true
                    DarkLightModeType.LIGHT -> false
                }
            ) {
                NavHost()
            }
        }
    }
}