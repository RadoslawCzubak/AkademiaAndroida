package pl.rczubak.kursakademiaandroida.core.api.model


import com.google.gson.annotations.SerializedName
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Character

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val code: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: CharactersLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: OriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacter() = Character(
        code,
        gender,
        id,
        image,
        location.toCharactersLocation(),
        name,
        origin.toOrigin(),
        species,
        status,
        type,
        url
    )
}