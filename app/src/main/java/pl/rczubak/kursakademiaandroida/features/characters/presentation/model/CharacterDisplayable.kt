package pl.rczubak.kursakademiaandroida.features.characters.presentation.model

import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Character

data class CharacterDisplayable(
    val code: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharactersLocationDisplayable,
    val name: String,
    val origin: OriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        code = character.code,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = CharactersLocationDisplayable(character.location),
        name = character.name,
        origin = OriginDisplayable(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}