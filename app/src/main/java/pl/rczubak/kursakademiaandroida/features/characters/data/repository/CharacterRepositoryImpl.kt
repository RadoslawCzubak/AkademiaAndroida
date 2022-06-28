package pl.rczubak.kursakademiaandroida.features.characters.data.repository

import pl.rczubak.kursakademiaandroida.core.api.RickAndMortyApi
import pl.rczubak.kursakademiaandroida.core.network.NetworkStateProvider
import pl.rczubak.kursakademiaandroida.features.characters.data.local.CharacterDao
import pl.rczubak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.rczubak.kursakademiaandroida.features.characters.domain.CharacterRepository
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val api: RickAndMortyApi,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharacters(it) }
        } else {
            getCharactersFromLocalDb()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return api.getCharacters().results
            .map { it.toCharacter() }
    }

    private suspend fun getCharactersFromLocalDb(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }

    private suspend fun saveCharacters(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
        characterDao.saveCharacters()
    }
}