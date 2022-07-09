package pl.rczubak.kursakademiaandroida.mock

import org.jetbrains.annotations.TestOnly
import pl.rczubak.kursakademiaandroida.core.api.model.*
import pl.rczubak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.rczubak.kursakademiaandroida.features.characters.data.local.model.CharacterLocationCached
import pl.rczubak.kursakademiaandroida.features.characters.data.local.model.OriginCached
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.rczubak.kursakademiaandroida.features.locations.data.local.model.LocationCached

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
    url = "episode url"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "name string",
    url = "url string"
)

@TestOnly
fun OriginRemote.Companion.mock() = OriginRemote(
    name = "name string",
    url = "url string"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    created = "created string",
    code = listOf("code string", "code string2"),
    gender = "gender string",
    id = 1,
    image = "image string",
    location = CharacterLocationRemote.mock(),
    name = "name string",
    origin = OriginRemote.mock(),
    species = "spieces",
    status = "status string",
    type = "type string",
    url = "url string"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(CharacterRemote.mock(), CharacterRemote.mock(), CharacterRemote.mock())
)

@TestOnly
fun OriginCached.Companion.mock() = OriginCached(
    name = "name string",
    url = "url string"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    name = "name string",
    url = "url string"
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    code = listOf("code1", "code2"),
    gender = "gender string",
    image = "image string",
    location = CharacterLocationCached.mock(),
    name = "name string",
    origin = OriginCached.mock(),
    species = "spieces",
    status = "status string",
    type = "type string",
    url = "url string"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    created = "created string",
    dimension = "dimension string",
    id = 1,
    name = "name string",
    residents = listOf("residents1", "residents2"),
    type = "type string",
    url = "url string"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock(),
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    dimension = "dimension string",
    id = 1,
    name = "name string",
    residents = listOf("residents1", "residents2"),
    type = "type string",
    url = "url string"
)