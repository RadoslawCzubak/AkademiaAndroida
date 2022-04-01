package pl.rczubak.kursakademiaandroida.features.characters.presentation.model

import pl.rczubak.kursakademiaandroida.features.characters.domain.model.CharactersLocation

data class CharactersLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(charactersLocation: CharactersLocation) : this(
        charactersLocation.name,
        charactersLocation.url
    )
}