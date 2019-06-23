package com.acm.workshop.aparat.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.acm.workshop.aparat.local.model.LocalVideo

@Dao
interface VideoDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideo(video: LocalVideo)

    @Query("select * from video")
    fun listAll() : List<LocalVideo>

}