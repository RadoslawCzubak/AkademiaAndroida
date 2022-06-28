package pl.rczubak.kursakademiaandroida.mock

import org.jetbrains.annotations.TestOnly
import pl.rczubak.kursakademiaandroida.core.api.model.EpisodeRemote
import pl.rczubak.kursakademiaandroida.core.api.model.EpisodesResponse
import pl.rczubak.kursakademiaandroida.core.api.model.ResponseInfo
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next pg url",
    prev = "prev pg url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "episode created date"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    ResponseInfo.mock(), listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url")