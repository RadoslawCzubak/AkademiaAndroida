package pl.rczubak.kursakademiaandroida.features.episodes.presentation.model

import pl.rczubak.kursakademiaandroida.features.episodes.domain.model.Episode

data class EpisodeDisplayable(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
) {
    constructor(episode: Episode) : this(
        airDate = episode.airDate,
        characters = episode.characters,
        code = episode.code,
        id = episode.id,
        name = episode.name,
        url = episode.url,
    )
}