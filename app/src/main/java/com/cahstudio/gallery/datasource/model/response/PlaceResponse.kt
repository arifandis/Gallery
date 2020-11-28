package com.cahstudio.gallery.datasource.model.response

import androidx.annotation.Keep
import com.cahstudio.gallery.datasource.model.Header
import com.cahstudio.gallery.datasource.model.Place
import com.google.gson.annotations.SerializedName

@Keep
data class PlaceResponse(
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: Data?
){

    @Keep
    data class Data(
        @SerializedName("header") val header: Header,
        @SerializedName("content") val content: List<Place>
    )
}