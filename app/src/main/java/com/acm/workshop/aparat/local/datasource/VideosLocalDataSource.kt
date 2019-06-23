package com.acm.workshop.aparat.local.datasource

import com.acm.workshop.aparat.local.dao.VideoDao
import com.acm.workshop.aparat.local.model.LocalVideo
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import javax.inject.Inject

class VideosLocalDataSource @Inject constructor(private val videoDao: VideoDao){

    fun insertVideo(video: LocalVideo){
        videoDao.insertVideo(video)
    }

    fun listAllVideos() = Single.fromCallable{
        videoDao.listAll()
    }

}