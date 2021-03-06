package pl.rczubak.kursakademiaandroida.features.characters.domain.usecase

import pl.rczubak.kursakademiaandroida.core.base.UseCase
import pl.rczubak.kursakademiaandroida.features.characters.domain.CharacterRepository
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(
    private val characterRepository: CharacterRepository
) : UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit): List<Character> = characterRepository.getCharacters()
}