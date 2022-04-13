package pl.rczubak.kursakademiaandroida.features.locations.domain

import pl.rczubak.kursakademiaandroida.core.base.UseCase
import pl.rczubak.kursakademiaandroida.features.locations.LocationRepository
import pl.rczubak.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(
    private val locationRepository: LocationRepository
) : UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit): List<Location> = locationRepository.getLocations()
}