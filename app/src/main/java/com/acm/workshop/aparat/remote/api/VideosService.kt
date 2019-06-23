package com.acm.workshop.aparat.remote.api

import com.acm.workshop.aparat.remote.api.VideosService.Companion.BASE_URL
import com.acm.workshop.aparat.remote.dto.VideosDto
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface VideosService{

    @GET("/etc/api/mostviewedvideos")
    abstract fun getVideos() : Single<VideosDto>

    companion object {
        const val BASE_URL = "http://www.aparat.com/"
    }
}

fun main(){

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .build()


    val service = retrofit.create(VideosService::class.java)

    service.getVideos()
        .subscribe({
            println(it)
        },{
            println(it)
        }

        )

}