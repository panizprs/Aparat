package com.acm.workshop.aparat.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acm.workshop.aparat.data.entity.VideoEntity
import com.acm.workshop.aparat.data.repository.VideosRepository


class HomeViewModel(private val repository: VideosRepository) : ViewModel() {


    private val _videos = MutableLiveData<List<VideoEntity>>()
    val videos : LiveData<List<VideoEntity>> = _videos

    private val _error = MutableLiveData<Throwable>()
    val error : LiveData<Throwable> = _error

    fun getVideos() {
        println("getVideos")
        repository.getVideos(::successGetVideos, ::failGetVideos)
    }

    private fun successGetVideos(videos: List<VideoEntity>) {
        println(videos.size)
        _videos.value = videos
    }

    private fun failGetVideos(throwable: Throwable) {
        println(throwable.message)
        _error.value = throwable
    }
}
