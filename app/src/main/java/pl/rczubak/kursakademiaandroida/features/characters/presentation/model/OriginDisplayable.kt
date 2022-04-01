package pl.rczubak.kursakademiaandroida.features.characters.presentation.model

import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Origin

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(origin.name, origin.url)
}