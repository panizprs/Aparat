package com.acm.workshop.aparat.remote.api

import com.acm.workshop.aparat.remote.api.VideosService.Companion.BASE_URL
import com.acm.workshop.aparat.remote.dto.VideosDto
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface VideosService{

    @GET("{page}")
    abstract fun getVideos(@Path(value = "page", encoded = true) page : String) : Single<VideosDto>

    companion object {
        const val BASE_URL = "http://www.aparat.com/"
        const val BASE_URL_SIZE = 22
    }
}
