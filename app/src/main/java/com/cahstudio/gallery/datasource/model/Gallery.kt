package com.cahstudio.gallery.datasource.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Gallery(
    @SerializedName("caption") val caption: String?,
    @SerializedName("thumbnail") val thumnail: String?,
    @SerializedName("image") val image: String?
)