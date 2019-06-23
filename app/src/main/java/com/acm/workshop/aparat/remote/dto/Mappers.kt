package com.acm.workshop.aparat.remote.dto

import com.acm.workshop.aparat.data.entity.AparatEntity
import com.acm.workshop.aparat.data.entity.VideoEntity

fun Mostviewedvideo.toVideoEntity() = VideoEntity(
    id = id,
    bigPoster = bigPoster,
    duration = duration,
    profilePhoto = profilePhoto,
    title = title,
    username = username
)

fun VideosDto.toApartEntity() = AparatEntity(
    videos = mostviewedvideos.map { mostviewedvideo ->
        mostviewedvideo.toVideoEntity()
    },
    nextPage = ui?.pagingForward
)