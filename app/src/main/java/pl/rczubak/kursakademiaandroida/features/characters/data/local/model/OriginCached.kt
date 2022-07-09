package pl.rczubak.kursakademiaandroida.features.characters.data.local.model

import androidx.room.PrimaryKey
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Origin

data class OriginCached(
    @PrimaryKey
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        origin.name, origin.url
    )

    companion object

    fun toOrigin(): Origin {
        return Origin(name, url)
    }
}
