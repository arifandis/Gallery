package com.cahstudio.gallery.datasource.model.response

import androidx.annotation.Keep
import com.cahstudio.gallery.datasource.model.Gallery
import com.google.gson.annotations.SerializedName

@Keep
data class GalleryResponse(
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: List<Gallery>
)