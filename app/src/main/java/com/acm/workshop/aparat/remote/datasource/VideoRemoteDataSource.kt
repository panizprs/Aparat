package com.acm.workshop.aparat.remote.datasource

import com.acm.workshop.aparat.remote.api.VideosService
import com.acm.workshop.aparat.remote.dto.VideosDto
import io.reactivex.Single

class VideoRemoteDataSource(private val videosService: VideosService){

    fun getVideos() : Single<VideosDto> {
        return videosService.getVideos()
    }
}