package li.by.amazinggifs.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


val FIXED_WIDTH = 200

data class Data (
    @SerializedName("data")
    val gifs : List<Gif>
)

@Parcelize
data class Gif (
    val id: String,
    val title: String,
    val images : Images
) : Parcelable

@Parcelize
data class Images(val fixedWidth: FixedWidth) : Parcelable

@Parcelize
data class FixedWidth(val height: Int, val url: String) : Parcelable
