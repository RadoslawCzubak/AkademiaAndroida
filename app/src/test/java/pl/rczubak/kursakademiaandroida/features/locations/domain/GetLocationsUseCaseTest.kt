package pl.rczubak.kursakademiaandroida.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.rczubak.kursakademiaandroida.features.locations.domain.usecase.GetLocationsUseCase

internal class GetLocationsUseCaseTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `when use case is invoked then execute getLocations method`() {
        // Given
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)

        // When
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // Then
        coVerify { repository.getLocations() }
    }

}