package pl.rczubak.kursakademiaandroida.features.episodes.data.repository

import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import pl.rczubak.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi
) : EpisodeRepository {
    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes().results.map {
            it.toEpisode()
        }
    }
}