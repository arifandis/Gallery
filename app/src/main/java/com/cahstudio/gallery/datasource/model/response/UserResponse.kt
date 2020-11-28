package com.cahstudio.gallery.datasource.model.response

import androidx.annotation.Keep
import com.cahstudio.gallery.datasource.model.User
import com.google.gson.annotations.SerializedName

@Keep
data class UserResponse(
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: User?
)