package pl.rczubak.kursakademiaandroida.features.data.remote.model


import com.google.gson.annotations.SerializedName
import pl.rczubak.kursakademiaandroida.features.characters.domain.model.Origin

data class OriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOrigin() = Origin(name, url)
}