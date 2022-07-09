package pl.rczubak.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModules
    .plus(appModule)
    .plus(databaseModule)
    .plus(networkModule)