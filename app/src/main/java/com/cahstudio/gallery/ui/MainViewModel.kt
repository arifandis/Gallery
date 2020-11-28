package com.cahstudio.gallery.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cahstudio.gallery.datasource.model.response.GalleryResponse
import com.cahstudio.gallery.datasource.model.response.PlaceResponse
import com.cahstudio.gallery.datasource.model.response.UserResponse
import com.cahstudio.gallery.repository.MainRepository
import com.google.gson.Gson
import io.reactivex.rxjava3.kotlin.subscribeBy
import retrofit2.HttpException

class MainViewModel(val repo: MainRepository): ViewModel() {

    fun getPlace(): LiveData<PlaceResponse>{
        val response = MutableLiveData<PlaceResponse>()
        repo.getPlace().subscribeBy(
            onComplete = {
                print("Done")
            },
            onError = {
                it.printStackTrace()
                var errorResponse: PlaceResponse
                try {
                    val error = it as HttpException
                    val string = error.response()?.errorBody()?.string()
                    string?.let { it1 -> Log.d("error", it1) }
                    val gson = Gson()
                    val res = gson.fromJson(string, PlaceResponse::class.java)
                    response.value = res
                }catch (e: Exception){
                    Log.d("error", it.message+" - "+it.localizedMessage)
                    var message = ""
                    if (it.localizedMessage.contains("Unable to resolve host") || it.message?.contains("Unable to resolve host")!!){
                        message = "Tidak ada jaringan internet"
                    }else{
                        message = it.localizedMessage
                    }
                    errorResponse = PlaceResponse(404, message, null)
                    response.value = errorResponse
                }
            },
            onNext = {
                response.value = it
            }
        )

        return response
    }

    fun getGallery(): LiveData<GalleryResponse>{
        val response = MutableLiveData<GalleryResponse>()
        repo.getGallery().subscribeBy(
            onComplete = {
                print("Done")
            },
            onError = {
                it.printStackTrace()
                var errorResponse: GalleryResponse
                try {
                    val error = it as HttpException
                    val string = error.response()?.errorBody()?.string()
                    string?.let { it1 -> Log.d("error", it1) }
                    val gson = Gson()
                    val res = gson.fromJson(string, GalleryResponse::class.java)
                    response.value = res
                }catch (e: Exception){
                    Log.d("error", it.message+" - "+it.localizedMessage)
                    var message = ""
                    if (it.localizedMessage.contains("Unable to resolve host") || it.message?.contains("Unable to resolve host")!!){
                        message = "Tidak ada jaringan internet"
                    }else{
                        message = it.localizedMessage
                    }
                    errorResponse = GalleryResponse(404, message, mutableListOf())
                    response.value = errorResponse
                }
            },
            onNext = {
                response.value = it
            }
        )

        return response
    }

    fun getUser(): LiveData<UserResponse>{
        val response = MutableLiveData<UserResponse>()
        repo.getUser().subscribeBy(
            onComplete = {
                print("Done")
            },
            onError = {
                it.printStackTrace()
                var errorResponse: UserResponse
                try {
                    val error = it as HttpException
                    val string = error.response()?.errorBody()?.string()
                    string?.let { it1 -> Log.d("error", it1) }
                    val gson = Gson()
                    val res = gson.fromJson(string, UserResponse::class.java)
                    response.value = res
                }catch (e: Exception){
                    Log.d("error", it.message+" - "+it.localizedMessage)
                    var message = ""
                    if (it.localizedMessage.contains("Unable to resolve host") || it.message?.contains("Unable to resolve host")!!){
                        message = "Tidak ada jaringan internet"
                    }else{
                        message = it.localizedMessage
                    }
                    errorResponse = UserResponse(404, message, null)
                    response.value = errorResponse
                }
            },
            onNext = {
                response.value = it
            }
        )

        return response
    }
}