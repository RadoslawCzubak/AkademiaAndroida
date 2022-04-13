package pl.rczubak.kursakademiaandroida.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.features.episodes.domain.usecase.GetEpisodesUseCase

internal class GetEpisodesUseCaseTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `when use case is invoked then execute getEpisodes method from repository`() {
        // Given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        // When
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // Then
        coVerify { repository.getEpisodes() }
    }
}