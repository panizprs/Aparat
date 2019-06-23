package com.acm.workshop.aparat.app.ui.home

import androidx.lifecycle.ViewModel
import com.acm.workshop.aparat.data.entity.VideoEntity
import com.acm.workshop.aparat.data.repository.VideosRepository


class HomeViewModel(private val repository: VideosRepository) : ViewModel() {


    fun getVideos() {
        println("getVideos")
        repository.getVideos(::successGetVideos, ::failGetVideos)
    }

    private fun successGetVideos(videos: List<VideoEntity>) {
        println(videos.size)
    }

    private fun failGetVideos(throwable: Throwable) {
        println(throwable.message)
    }
}
