package pl.rczubak.kursakademiaandroida.features.episodes.domain.model

import com.google.gson.annotations.SerializedName

data class Episode(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
)
