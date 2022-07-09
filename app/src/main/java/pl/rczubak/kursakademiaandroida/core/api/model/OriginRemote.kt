package pl.rczubak.kursakademiaandroida.core.api.model


import com.google.gson.annotations.SerializedName
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Origin

data class OriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toOrigin() = Origin(name, url)
}