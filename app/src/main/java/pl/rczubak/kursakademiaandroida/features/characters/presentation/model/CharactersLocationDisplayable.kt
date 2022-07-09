package pl.rczubak.kursakademiaandroida.features.characters.presentation.model

import pl.rczubak.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharactersLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        characterLocation.name,
        characterLocation.url
    )
}