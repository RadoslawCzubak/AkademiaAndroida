package pl.rczubak.kursakademiaandroida.features.characters.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.core.api.model.CharactersResponse
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProvider
import pl.rczubak.kursakademiaandroida.features.characters.data.local.CharacterDao
import pl.rczubak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.rczubak.kursakademiaandroida.features.characters.domain.CharacterRepository
import pl.rczubak.kursakademiaandroida.mock.mock

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from api `(){
        // Given
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val charactersDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(charactersDao, api, networkStateProvider)
        //When
        runBlocking { repository.getCharacters() }
        //Then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful fetch WHEN characters request THEN fetch characters are saved to local db `(){
        // Given
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val charactersDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(charactersDao, api, networkStateProvider)
        //When
        runBlocking { repository.getCharacters() }
        //Then
        coVerify { charactersDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local db `(){
        // Given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val charactersDao = mockk<CharacterDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(charactersDao, api, networkStateProvider)
        //When
        runBlocking { repository.getCharacters() }
        //Then
        coVerify { charactersDao.getCharacters() }
    }
}