package pl.rczubak.kursakademiaandroida.core.api

import pl.rczubak.kursakademiaandroida.core.api.model.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse
}