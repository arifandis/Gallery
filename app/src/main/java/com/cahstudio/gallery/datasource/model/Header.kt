package com.cahstudio.gallery.datasource.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Header(
    @SerializedName("title") val title: String?,
    @SerializedName("subtitle") val subtitle: String?
)