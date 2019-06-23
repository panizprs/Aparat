package com.acm.workshop.aparat.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.acm.workshop.aparat.local.dao.VideoDao
import com.acm.workshop.aparat.local.model.LocalVideo

@Database(entities = [LocalVideo::class], version = 1)
abstract class AppDataBase() : RoomDatabase(){

    abstract fun videoDao() : VideoDao

}