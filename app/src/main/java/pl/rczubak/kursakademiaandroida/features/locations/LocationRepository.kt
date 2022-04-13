package pl.rczubak.kursakademiaandroida.features.locations

import pl.rczubak.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}