package li.by.amazinggifs.model

import com.google.gson.annotations.SerializedName


val FIXED_WIDTH = 200

data class Data (
    @SerializedName("data")
    val gifs : List<Gif>
)

data class Gif (
    val id: String,
    val title: String,
    val images : Images
)

data class Images(val fixedWidth: FixedWidth)

data class FixedWidth(val height: Int, val url: String)
