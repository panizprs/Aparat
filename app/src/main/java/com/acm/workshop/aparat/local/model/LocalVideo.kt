package com.acm.workshop.aparat.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video")
data class LocalVideo(
    @PrimaryKey val id: String,
    val title: String?,
    val duration: String?,
    val profilePhoto: String?,
    val bigPoster: String?,
    val username: String?
)