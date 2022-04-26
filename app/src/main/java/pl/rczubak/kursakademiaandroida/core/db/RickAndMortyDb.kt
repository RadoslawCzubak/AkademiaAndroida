package pl.rczubak.kursakademiaandroida.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConventer::class)
abstract class RickAndMortyDb : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
}