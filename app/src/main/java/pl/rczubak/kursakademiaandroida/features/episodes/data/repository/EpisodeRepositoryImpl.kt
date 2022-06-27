package pl.rczubak.kursakademiaandroida.features.episodes.data.repository

import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.rczubak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import pl.rczubak.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val episodeDao: EpisodeDao
) : EpisodeRepository {
    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes().results.map {
            it.toEpisode()
        }
            .also { saveEpisodes(it) }
    }

    private suspend fun saveEpisodes(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }
}