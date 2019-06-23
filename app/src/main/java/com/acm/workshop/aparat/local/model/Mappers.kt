package com.acm.workshop.aparat.local.model

import com.acm.workshop.aparat.data.entity.VideoEntity

fun LocalVideo.toVideoEntity() = VideoEntity(
    id = id,
    username = username,
    title = title,
    profilePhoto = profilePhoto,
    duration = duration,
    bigPoster = bigPoster
)