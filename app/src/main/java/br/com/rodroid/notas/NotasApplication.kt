package br.com.rodroid.notas

import android.app.Application
import br.com.rodroid.notas.presentation.di.modules.viewmodels.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NotasApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NotasApplication)
            modules(
                viewModelModule
            )
        }
    }
}