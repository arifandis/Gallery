package com.cahstudio.gallery.datasource.api

import com.cahstudio.gallery.datasource.model.response.GalleryResponse
import com.cahstudio.gallery.datasource.model.response.PlaceResponse
import com.cahstudio.gallery.datasource.model.response.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IApiService {

    @GET("place.json")
    fun getPlaceList(): Single<PlaceResponse>

    @GET("gallery.json")
    fun getGallery(): Single<GalleryResponse>

    @GET("user.json")
    fun getUser(): Single<UserResponse>
}