package pl.rczubak.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val code: List<String>,
    val gender: String,
    val image: String,
    @Embedded(prefix = "characterLocationCached")
    val location: CharacterLocationCached,
    val name: String,
    @Embedded(prefix = "originCached")
    val origin: OriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    constructor(character: Character) : this(
        character.id,
        character.code,
        character.gender,
        character.image,
        CharacterLocationCached(character.location),
        character.name,
        OriginCached(character.origin),
        character.species,
        character.status,
        character.type,
        character.url
    )

    companion object

    fun toCharacter(): Character {
        return Character(
            code,
            gender,
            id,
            image,
            location.toCharactersLocation(),
            name,
            origin.toOrigin(),
            species,
            status,
            type,
            url
        )
    }
}
