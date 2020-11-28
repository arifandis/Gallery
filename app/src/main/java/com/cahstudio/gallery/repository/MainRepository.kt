package com.cahstudio.gallery.repository

import com.cahstudio.gallery.datasource.api.IApiService
import com.cahstudio.gallery.datasource.model.response.GalleryResponse
import com.cahstudio.gallery.datasource.model.response.PlaceResponse
import com.cahstudio.gallery.datasource.model.response.UserResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainRepository(val api: IApiService) {

    fun getPlace(): Observable<PlaceResponse>{
        return api.getPlaceList().toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun getGallery(): Observable<GalleryResponse>{
        return api.getGallery().toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun getUser(): Observable<UserResponse>{
        return api.getUser().toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}