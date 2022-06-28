package pl.rczubak.kursakademiaandroida.features.locations.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.rczubak.kursakademiaandroida.features.locations.domain.model.Location

@Entity
data class LocationCached(
    @PrimaryKey
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        location.id,
        location.dimension,
        location.name,
        location.residents,
        location.type,
        location.url
    )

    companion object

    fun toLocation(): Location {
        return Location(dimension, id, name, residents, type, url)
    }
}
