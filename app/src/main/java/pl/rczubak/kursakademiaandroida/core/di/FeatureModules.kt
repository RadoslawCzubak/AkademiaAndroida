package pl.rczubak.kursakademiaandroida.core.di

import org.koin.dsl.module
import pl.rczubak.kursakademiaandroida.features.episodes.di.episodeModule

val featureModules = module {
    episodeModule
}