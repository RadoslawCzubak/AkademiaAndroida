package pl.rczubak.kursakademiaandroida.features.episodes.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.rczubak.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import pl.rczubak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import pl.rczubak.kursakademiaandroida.features.episodes.domain.usecase.GetEpisodesUseCase
import pl.rczubak.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import pl.rczubak.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel

val episodeModule = module {

    // data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}