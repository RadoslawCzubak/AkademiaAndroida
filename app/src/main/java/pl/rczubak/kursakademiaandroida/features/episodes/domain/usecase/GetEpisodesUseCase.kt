package pl.rczubak.kursakademiaandroida.features.episodes.domain.usecase

import pl.rczubak.kursakademiaandroida.core.base.UseCase
import pl.rczubak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import pl.rczubak.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}