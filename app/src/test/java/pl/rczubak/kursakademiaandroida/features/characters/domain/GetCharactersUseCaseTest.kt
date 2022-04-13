package pl.rczubak.kursakademiaandroida.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.features.characters.CharacterRepository

internal class GetCharactersUseCaseTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `when use case is invoked then execute getCharacters method`() {
        // Given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        // When
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // Then
        coVerify { repository.getCharacters() }
    }
}