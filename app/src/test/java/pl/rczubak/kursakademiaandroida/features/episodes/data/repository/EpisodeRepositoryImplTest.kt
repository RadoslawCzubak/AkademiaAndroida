package pl.rczubak.kursakademiaandroida.features.episodes.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.core.api.model.EpisodesResponse
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProvider
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import pl.rczubak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.rczubak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import pl.rczubak.kursakademiaandroida.mock.mock

internal class EpisodeRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        // Given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // When
        runBlocking { repository.getEpisodes() }

        // Then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN episodes request THEN save episodes to local db`() {
        // Given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // When
        runBlocking { repository.getEpisodes() }

        // Then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local db`() {
        // Given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // When
        runBlocking { repository.getEpisodes() }

        // Then
        coVerify { episodeDao.getEpisodes() }
    }
}