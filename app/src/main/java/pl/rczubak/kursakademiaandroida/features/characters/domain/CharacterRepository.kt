package pl.rczubak.kursakademiaandroida.features.characters.domain

import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}