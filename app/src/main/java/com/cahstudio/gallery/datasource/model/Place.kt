package com.cahstudio.gallery.datasource.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Place(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("media") val media: List<String>
)