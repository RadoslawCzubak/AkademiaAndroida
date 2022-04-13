package pl.rczubak.kursakademiaandroida.features.episodes.domain

import pl.rczubak.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}