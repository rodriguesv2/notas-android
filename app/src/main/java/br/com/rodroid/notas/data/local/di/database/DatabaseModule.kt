package br.com.rodroid.notas.data.local.di.database

import androidx.room.Room
import br.com.rodroid.notas.data.local.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "notas.db"
        ).build()
    }

    single {
        get<AppDatabase>().noteDao()
    }
}
