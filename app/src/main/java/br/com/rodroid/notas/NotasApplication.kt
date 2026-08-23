package br.com.rodroid.notas

import android.app.Application
import br.com.rodroid.notas.data.local.di.database.databaseModule
import br.com.rodroid.notas.data.local.di.repository.repositoryModule
import br.com.rodroid.notas.domain.di.useCaseModule
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
                databaseModule,
                viewModelModule,
                repositoryModule,
                useCaseModule,
            )
        }
    }
}