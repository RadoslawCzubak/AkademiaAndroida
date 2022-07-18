package pl.rczubak.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.core.base.UIState
import pl.rczubak.kursakademiaandroida.features.episodes.domain.model.Episode
import pl.rczubak.kursakademiaandroida.features.episodes.domain.usecase.GetEpisodesUseCase
import pl.rczubak.kursakademiaandroida.mock.mock
import pl.rczubak.kursakademiaandroida.utils.ViewModelTest
import pl.rczubak.kursakademiaandroida.utils.getOrAwaitValue
import pl.rczubak.kursakademiaandroida.utils.observeForTesting

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        // GIVEN
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)
        // WHEN
        viewModel.episodes.observeForTesting()
        // THEN
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {
        // GIVEN
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)
        // WHEN
        viewModel.episodes.observeForTesting()
        // THEN
        verify {
            useCase(Unit, viewModel.viewModelScope, any(), any())
        }
    }

    @Test
    fun `GIVEN use case result is success WHEN episode live data is observed THEN set result in livedata`() {
        // GIVEN
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val viewModel = EpisodeViewModel(useCase)

        // WHEN
        viewModel.episodes.observeForTesting()
        // THEN
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set errpr message in live data`() {
        // GIVEN
        val throwable = Throwable("Oops... something went wrong!")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        // WHEN
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()
        // THEN
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}