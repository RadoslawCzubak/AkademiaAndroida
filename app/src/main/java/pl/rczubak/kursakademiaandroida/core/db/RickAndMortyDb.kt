package pl.rczubak.kursakademiaandroida.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.rczubak.kursakademiaandroida.features.characters.data.local.CharacterDao
import pl.rczubak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.rczubak.kursakademiaandroida.features.locations.data.local.LocationDao
import pl.rczubak.kursakademiaandroida.features.locations.data.local.model.LocationCached

@Database(
    entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class],
    version = 1
)
@TypeConverters(ListConventer::class)
abstract class RickAndMortyDb : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
}