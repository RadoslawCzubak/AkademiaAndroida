package pl.rczubak.kursakademiaandroida.features.locations.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.core.api.model.LocationsResponse
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProvider
import pl.rczubak.kursakademiaandroida.features.locations.data.local.LocationDao
import pl.rczubak.kursakademiaandroida.features.locations.data.local.model.LocationCached
import pl.rczubak.kursakademiaandroida.features.locations.domain.LocationRepository
import pl.rczubak.kursakademiaandroida.mock.mock

internal class LocationRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from api `() {
        // Given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationsDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(locationsDao, api, networkStateProvider)
        //When
        runBlocking { repository.getLocations() }
        //Then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful fetch WHEN locations request THEN fetch locations are saved to local db `() {
        // Given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationsDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(locationsDao, api, networkStateProvider)
        //When
        runBlocking { repository.getLocations() }
        //Then
        coVerify { locationsDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local db `() {
        // Given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationsDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(
                LocationCached.mock(),
                LocationCached.mock(),
                LocationCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(locationsDao, api, networkStateProvider)
        //When
        runBlocking { repository.getLocations() }
        //Then
        coVerify { locationsDao.getLocations() }
    }
}