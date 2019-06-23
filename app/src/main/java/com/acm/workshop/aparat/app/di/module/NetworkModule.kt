package com.acm.workshop.aparat.app.di.module

import com.acm.workshop.aparat.remote.api.VideosService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRxJavaConverter() = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideGsonConverter() = GsonConverterFactory.create()

    @Provides
    fun provideOKHttpClient() = OkHttpClient()

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        client: OkHttpClient
    ) = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .baseUrl(VideosService.BASE_URL)
        .client(client)
        .build()


    @Provides
    fun provideVideosService(retrofit: Retrofit) = retrofit.create(VideosService::class.java)
}