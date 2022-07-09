package pl.rczubak.kursakademiaandroida.features.characters.data.local.model

import androidx.room.PrimaryKey
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharacterLocationCached(
    @PrimaryKey
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        characterLocation.name, characterLocation.url
    )

    companion object

    fun toCharactersLocation(): CharacterLocation {
        return CharacterLocation(name, url)
    }
}
