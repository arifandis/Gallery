package com.cahstudio.gallery.datasource.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String?,
    @SerializedName("fullname") val fullname: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("avatar") val avatar: String?
)