package com.acm.workshop.aparat.app.di.module

import android.content.Context
import androidx.room.Room
import com.acm.workshop.aparat.local.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule{


    @Singleton
    @Provides
    fun provideAppDataBase(context : Context) = Room.databaseBuilder(context, AppDataBase::class.java, "VideoDB.data").build()


    @Provides
    @Singleton
    fun provideVideoDao(appDataBase: AppDataBase) = appDataBase.videoDao()
}