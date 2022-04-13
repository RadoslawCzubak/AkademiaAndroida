package pl.rczubak.kursakademiaandroida.features.locations.domain

import pl.rczubak.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}