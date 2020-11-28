package com.cahstudio.gallery.di

import com.cahstudio.gallery.datasource.api.IApiService
import com.cahstudio.gallery.repository.MainRepository
import com.cahstudio.gallery.ui.MainViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.BuildConfig
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single { MainRepository(get()) }
}

val apiModule = module {
    fun provideIApiService(retrofit: Retrofit): IApiService{
        return retrofit.create(IApiService::class.java)
    }

    single { provideIApiService(get()) }
}

val networkModule = module {
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.NONE
            })
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dot-mobile-test.web.app/")
            .client(client)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(factory))
            .build()
    }

    single { provideGson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }

}