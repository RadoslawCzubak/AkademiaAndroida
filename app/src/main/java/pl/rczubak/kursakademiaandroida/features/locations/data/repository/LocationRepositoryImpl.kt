package pl.rczubak.kursakademiaandroida.features.locations.data.repository

import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProvider
import pl.rczubak.kursakademiaandroida.features.locations.data.local.LocationDao
import pl.rczubak.kursakademiaandroida.features.locations.data.local.model.LocationCached
import pl.rczubak.kursakademiaandroida.features.locations.domain.LocationRepository
import pl.rczubak.kursakademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val locationDao: LocationDao,
    private val api: RickAndMortyApi,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationsFromApi()
                .also {
                    saveLocations(it)
                }
        } else {
            getLocationsFromLocalDb()
        }
    }

    private suspend fun getLocationsFromApi(): List<Location> {
        return api.getLocations().results
            .map { it.toLocation() }
    }

    private suspend fun getLocationsFromLocalDb(): List<Location> {
        return locationDao.getLocations()
            .map { it.toLocation() }
    }

    private suspend fun saveLocations(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let {
                locationDao.saveLocations(*it)
            }
    }
}