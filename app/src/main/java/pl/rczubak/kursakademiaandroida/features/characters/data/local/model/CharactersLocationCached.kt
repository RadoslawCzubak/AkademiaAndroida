package pl.rczubak.kursakademiaandroida.features.characters.data.local.model

import androidx.room.PrimaryKey
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.CharactersLocation

data class CharactersLocationCached(
    @PrimaryKey
    val name: String,
    val url: String
) {
    constructor(charactersLocation: CharactersLocation) : this(
        charactersLocation.name, charactersLocation.url
    )

    companion object

    fun toCharactersLocation(): CharactersLocation {
        return CharactersLocation(name, url)
    }
}
