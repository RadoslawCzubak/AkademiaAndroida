package pl.rczubak.kursakademiaandroida.core.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.rczubak.kursakademiaandroida.features.data.RickAndMortyDb

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            RickAndMortyDb::class.java,
            "rick-and-morty-db"
        ).build()
    }
}