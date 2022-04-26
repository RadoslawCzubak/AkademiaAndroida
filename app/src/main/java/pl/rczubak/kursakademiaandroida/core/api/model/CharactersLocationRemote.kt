package pl.rczubak.kursakademiaandroida.core.api.model


import com.google.gson.annotations.SerializedName
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.CharactersLocation

data class CharactersLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharactersLocation() = CharactersLocation(name, url)
}