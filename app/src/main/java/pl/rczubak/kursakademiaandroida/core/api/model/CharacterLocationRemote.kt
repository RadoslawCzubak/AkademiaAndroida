package pl.rczubak.kursakademiaandroida.core.api.model


import com.google.gson.annotations.SerializedName
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharactersLocation() = CharacterLocation(name, url)
}